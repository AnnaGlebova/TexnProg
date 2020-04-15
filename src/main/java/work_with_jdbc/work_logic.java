package work_with_jdbc;
import work_with_jdbc.classes.Account;
import work_with_jdbc.classes.Operation;
import work_with_jdbc.classes.User;
import work_with_jdbc.managers.manageAccount;
import work_with_jdbc.managers.connectDB;
import work_with_jdbc.managers.manageOperation;
import work_with_jdbc.managers.manageUser;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class work_logic {

    private static Map<String, Float> converter;
    private static Object SQLException;

    // Конвертер валют
    private static void initConverter(){
        converter = new HashMap<>();
        converter.put("RUB", 1f);
        converter.put("USD", 77.21f);
        converter.put("EUR", 85.95f);
    }

    // Подключение к бд
    public static void preparedAction() throws Throwable {
        try {
            initConverter();
            String url = "jdbc:mysql://localhost:3306/mydb?useUnicode=true&serverTimezone=UTC";
            String userName = "root";
            String password = "vkontakte1998";
            Connection con = connectDB.createConn(url, userName, password);
            manageUser.addConnection(con);
            manageAccount.addConnection(con);
            manageOperation.addConnection(con);
        }
        catch (SQLException | ClassNotFoundException e){
            System.out.println("Не удалось подключиться к базе!");
            e.printStackTrace();
            throw (Throwable) SQLException;
        }
    }

    // Создание пользователя
    public static void createUser(String login, String password, String address, String phone) throws SQLException {
        User user = new User(login, password, address, phone);
        manageUser.createUserDB(user);
    }

    // Создание счета для пользователя
    public static void createAccount(long idUser, String accCode, boolean defAcc) throws SQLException {
        Account account = new Account(idUser, accCode, defAcc);
        manageAccount.createAccountDB(account);
    }

    // Пополнение счета
    public static void addMoneyBalance(float sum, String accCode, Account account) throws SQLException {
        sum = sum * converter.get(accCode);
        // перевод валют в зависимости от currency
        float conv = converter.get(account.getAccCode());
        BigDecimal amount = new BigDecimal((sum + account.getAmount().doubleValue() * conv) / conv);
        account.setAmount(amount);
        manageAccount.updateAccountAmount(account);
    }

    // Перевод денег в соответствии с валютой
    public static String transferMoney(User userIn, User userOut, String accCode, BigDecimal amount)
            throws SQLException {
        List<Account> accIn = manageAccount.selectAccountForCurrency(userIn.getId(), accCode);
        Account acc;
        // Если нет аккаунта с такой валютой , берем аккаунт по умолчанию
        if (accIn.isEmpty()){
            acc = manageAccount.selectDefaultAccountUser(userIn.getId());
        }
        else{
            acc = accIn.get(0);
        }
        // Если нет дефолтного акка
        if (acc == null){
            return "У Вас еще нет счетов для списания!";
        }
        Account accOut = manageAccount.selectDefaultAccountUser(userOut.getId());
        // Если нет у получателя нет дефолтного акка
        if (accOut == null){
            return "У получателя еще нет счетов для получения средств!";
        }
        // Получить дату
        Date date = new Date();
        LocalDate dateOfOperation = date.toInstant().atZone(ZoneOffset.ofHours(4)).toLocalDate();
        BigDecimal amountRub = new BigDecimal(amount.doubleValue() * converter.get(accCode));
        // Рассчитать остаток на счете
        BigDecimal amountBefore = acc.getAmount();
        BigDecimal amountBalance = new BigDecimal(acc.getAmount().doubleValue() * converter.get(acc.getAccCode())
                - amountRub.doubleValue());
        if (amountBalance.doubleValue() < 0){
            return "Недостаточно средств для перевода!";
        }
        // Обновить счет отправителя
        acc.setAmount(new BigDecimal(amountBalance.doubleValue() / converter.get(acc.getAccCode())));
        manageAccount.updateAccountAmount(acc);
        // Обновить счет получателя
        double tmp = accOut.getAmount().doubleValue() * converter.get(accOut.getAccCode());
        BigDecimal addBalance = new BigDecimal((tmp + amountRub.doubleValue())
                / converter.get(accOut.getAccCode()));
        accOut.setAmount(addBalance);
        manageAccount.updateAccountAmount(accOut);
        // Добавление в журнал операций
        Operation operation = new Operation(dateOfOperation, accCode, acc.getId(), accOut.getId(), amount,
                amountBefore, acc.getAmount());
        manageOperation.createOperation(operation);
        return "Успешно!";
    }
}