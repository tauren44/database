package com.mateacademy;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Crud {
    private static Logger logger = Logger.getLogger(Crud.class);

    public void createData(String tableName, String values) {
        Connection connection = Connector.getConnection();
        Statement statement;
        String query;
        if (tableName.equals("developers")) {
            query = "INSERT INTO developers(name, age, sex, salary) VALUES(" + values + ");";
        } else if (tableName.equals("skills")) {
            query = "INSERT INTO skills(skill, lvl) VALUES(" + values + ");";
        } else if (tableName.equals("projects")) {
            query = "INSERT INTO projects(name, date, cost) VALUES(" + values + ");";
        } else if (tableName.equals("customers")) {
            query = "INSERT INTO customers(name, country) VALUES(" + values + ");";
        } else if (tableName.equals("companies")) {
            query = "INSERT INTO companies(name, site) VALUES(" + values + ");";
        } else throw new IllegalArgumentException();

        try {
            statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            logger.error("SQLException: " + e);
        }
    }

    public void readData(String tableName) throws SQLException {
        Connection connection = Connector.getConnection();
        ResultSet resultSet;
        String query = "SELECT * FROM " + tableName;
        Statement statement = connection.prepareStatement(query);
        resultSet = statement.executeQuery(query);
        ResultSetMetaData rsmd = resultSet.getMetaData();
        int columnsNumber = rsmd.getColumnCount();

        for (int i = 1; i <= columnsNumber; i++) {
            logger.info(rsmd.getColumnName(i) + " ");
        }
        logger.info("");
        while (resultSet.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                logger.info(resultSet.getString(i) + " ");
            }
            logger.info("");
        }

    }

    public void updateData(String tableName, String column, String newValue, String condition) {
        Connection connection = Connector.getConnection();
        Statement statement;
        String query = "UPDATE " + tableName + " SET " + column + " = " + newValue + " WHERE " + condition;

        try {
            statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            logger.error("SQLException: " + e);
        }
    }

    public void deleteData(String tableName, String condition) {
        Connection connection = Connector.getConnection();
        Statement statement;
        String query = "DELETE FROM " + tableName + " WHERE " + condition;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            logger.error("SQLException: " + e);
        }
    }
}
