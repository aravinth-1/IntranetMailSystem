package com.intranet.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/intranet_mail?useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "Aravinth";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Explicit driver load
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL JDBC Driver missing!", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}