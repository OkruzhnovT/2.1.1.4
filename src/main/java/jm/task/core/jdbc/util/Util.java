package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.lang.System.*;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/kata3";
    private static final String USERNAME = "root";
    private static final String PASWORD = "root";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    URL,
                    USERNAME, PASWORD);
        } catch (SQLException e) {
            err.println("Connection not established");
        }
        return connection;
    }


    public static void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            err.println("Connection not closed");
        }
    }
}
