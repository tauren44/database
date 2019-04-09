package com.mateacademy;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    private static String url = "jdbc:mysql://localhost:3306/homework" +
            "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static String user = "root";
    private static String password = "root";
    private static Logger logger = Logger.getLogger(Connector.class);


    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            logger.error("SQLException: " + e);
        }
        return connection;
    }
}
