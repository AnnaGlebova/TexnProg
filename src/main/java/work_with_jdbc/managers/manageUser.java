package work_with_jdbc.managers;
import work_with_jdbc.classes.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class manageUser {

    private static Connection con;

    public static void addConnection(Connection con) {
        manageUser.con = con;
    }

    // Добавление пользователя в бд
    public static void createUserDB(User user) throws SQLException {
        String createSQL;

        createSQL = "INSERT INTO users (login, password, address, phone) VALUES " +
                "(?, ?, ?, ?);";

        PreparedStatement psstmt = con.prepareStatement(createSQL);
        psstmt.setString(1, user.getLogin());
        psstmt.setString(2, user.getPassword());
        psstmt.setString(3, user.getAddress());
        psstmt.setString(4, user.getPhone());
        psstmt.executeUpdate();
    }

    // Получение юзера по логину
    private static List<User> selectUserForLogin(String login) throws SQLException {
        String selectSql = "SELECT * FROM users where login = ?";
        PreparedStatement stmt = con.prepareStatement(selectSql);
        stmt.setString(1, login);
        return getUsersFromDB(stmt);
    }

    // Получение юзера по телефону
    public static List<User> selectUserForPhone(String phone) throws SQLException {
        String selectSql = "SELECT * FROM users where phone = ?";
        PreparedStatement stmt = con.prepareStatement(selectSql);
        stmt.setString(1, phone);
        return getUsersFromDB(stmt);
    }

    // Получение юзера по логину и паролю (вход)
    private static List<User> selectUserForLogin(String login, String password) throws SQLException {
        String selectSql = "SELECT * FROM users where login = ? and password = ?";
        PreparedStatement stmt = con.prepareStatement(selectSql);
        stmt.setString(1, login);
        stmt.setString(2, password);
        return getUsersFromDB(stmt);
    }

    // Получение юзера по телефону и паролю (вход)
    private static List<User> selectUserForPhone(String phone, String password) throws SQLException {
        String selectSql = "SELECT * FROM users where phone = ? and password = ?";
        PreparedStatement stmt = con.prepareStatement(selectSql);
        stmt.setString(1, phone);
        stmt.setString(2, password);
        return getUsersFromDB(stmt);
    }

    // Возвращает список пользователей по заданному запросу
    private static List<User> getUsersFromDB(PreparedStatement stmt) throws SQLException {
        ResultSet rs = stmt.executeQuery();
        List<User> result = new ArrayList<>();
        while (rs.next()) {
            User userNew = new User(rs.getLong("id"), rs.getString("login"), rs.getString("password"),
                    rs.getString("address"), rs.getString("phone"));
            result.add(userNew);
        }
        return result;
    }

    // Проверка на несуществование такого пользователя
    public static boolean checkNoUserInDb(String login, String phone) throws SQLException {
        return selectUserForPhone(phone).isEmpty() && selectUserForLogin(login).isEmpty();
    }

    // Получение юзера по логину или номеру телефона (вход)
    public static User getUserForLoginOrPhone(String loginOrPhone, String password) throws SQLException {
        List<User> userList = selectUserForLogin(loginOrPhone, password);
        if (userList.isEmpty()) {
            userList = selectUserForPhone(loginOrPhone, password);
        }
        if (userList.isEmpty()) {
            return null;
        } else {
            return userList.get(0);
        }
    }

    // Получение юзера по id
    public static User selectUserForId(long idUser) throws SQLException {
        String selectSql = "SELECT * FROM users where id = ?";
        PreparedStatement stmt = con.prepareStatement(selectSql);
        stmt.setLong(1, idUser);
        return getUsersFromDB(stmt).get(0);
    }
}

