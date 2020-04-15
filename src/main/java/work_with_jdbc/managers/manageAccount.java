package work_with_jdbc.managers;

import work_with_jdbc.classes.Account;
import work_with_jdbc.classes.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class manageAccount {

    private static Connection con;

    public static void addConnection(Connection con) {
        manageAccount.con = con;
    }

    // Добавление нового счета в базу
    public static void createAccountDB(Account account) throws SQLException {
        List<Account> accList = manageAccount.selectAccountUsers(account.getIdUser());
        // Если есть счета у пользователя и добавляемый будет по умолчанию,
        // то остальные делаем не дефолтными
        if (!accList.isEmpty() && account.isDefAccount()) {
            updateAccountDefault(account.getIdUser(), false);
        }
        // Если счетов нет, то этот становится по умолчанию
        if (accList.isEmpty()) {
            account.setDefAccount(true);
        }
        String createSQL;
        createSQL = "INSERT INTO accounts (id_user, acc_code, def_acc) VALUES " +
                "(?, ?, ?);";

        PreparedStatement psstmt = con.prepareStatement(createSQL);
        psstmt.setLong(1, account.getIdUser());
        psstmt.setString(2, account.getAccCode());
        psstmt.setBoolean(3, account.isDefAccount());
        psstmt.executeUpdate();

    }

    // Обновление дефолтности у счетов юзера
    private static void updateAccountDefault(Long idUser, boolean defAcc) throws SQLException {
        String updateSql = "UPDATE accounts SET def_acc = ? where id_user = ?";
        PreparedStatement stmt = con.prepareStatement(updateSql);
        stmt.setBoolean(1, defAcc);
        stmt.setLong(2, idUser);
        stmt.executeUpdate();
    }

    // Обновление баланса аккаунта
    public static void updateAccountAmount(Account account) throws SQLException {
        String updateSql = "UPDATE accounts SET amount = ? where id_user = ? and acc_code = ?";
        PreparedStatement stmt = con.prepareStatement(updateSql);
        stmt.setBigDecimal(1, account.getAmount());
        stmt.setLong(2, account.getIdUser());
        stmt.setString(3, account.getAccCode());
        stmt.executeUpdate();
    }

    // Выборка счета юзера по валюте
    public static List<Account> selectAccountForCurrency(long idUser, String currency) throws SQLException {
        String selectSql = "SELECT * FROM accounts where id_user = ? and acc_code = ?";
        PreparedStatement stmt = con.prepareStatement(selectSql);
        stmt.setString(1, Long.toString(idUser));
        stmt.setString(2, currency);
        return getAccountFromDB(stmt);
    }

    // Выборка всех счетов юзера
    public static List<Account> selectAccountUsers(long idUser) throws SQLException {
        String selectSql = "SELECT * FROM accounts where id_user = ?";
        PreparedStatement stmt = con.prepareStatement(selectSql);
        stmt.setString(1, Long.toString(idUser));
        return getAccountFromDB(stmt);
    }

    // Выборка дефолтного счета юзера
    public static Account selectDefaultAccountUser(long idUser) throws SQLException {
        List<Account> accList = manageAccount.selectAccountUsers(idUser);
        for (Account acc : accList) {
            if (acc.isDefAccount()) {
                return acc;
            }
        }
        return null;
    }

    // Выборка аккаунтов и возврат списка аккаунтов по запросу
    private static List<Account> getAccountFromDB(PreparedStatement stmt) throws SQLException {
        ResultSet rs = stmt.executeQuery();
        List<Account> result = new ArrayList<>();
        while (rs.next()) {
            Account account = new Account(rs.getLong("id"), rs.getLong("id_user"), rs.getBigDecimal("amount"),
                    rs.getString("acc_code"), rs.getBoolean("def_acc"));
            result.add(account);
        }
        return result;
    }

    // Проверка на несуществование счета
    public static boolean checkNoAccCurrency(long idUser, String currency) throws SQLException {
        return selectAccountForCurrency(idUser, currency).isEmpty();
    }

    // Ищем пользователя данного аккаунта
    public static User getUserOfAccount(long idAccount) throws SQLException {
        String selectSql = "SELECT id_user FROM accounts where id = ?";
        PreparedStatement stmt = con.prepareStatement(selectSql);
        stmt.setLong(1, idAccount);
        ResultSet rs = stmt.executeQuery();
        long idUser = 0;
        while (rs.next()) {
            idUser = rs.getLong("id_user");
        }
        return manageUser.selectUserForId(idUser);
    }
}



