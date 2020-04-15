package work_with_jdbc.managers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectDB {

    public static Connection createConn(String connectionUrl, String userName, String password) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(connectionUrl, userName, password);
    }
}

