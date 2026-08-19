package org.ngphthinh.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DatabaseUtil {
    private static final String URL = "jdbc:mariadb://localhost:3306/demo_servlet";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "sapassword";

    private DatabaseUtil() {}

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.mariadb.jdbc.Driver");
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}