package com.mateacademy;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomersCrud {
    private static final Logger LOGGER = Logger.getLogger(CustomersCrud.class);

    public void addCustomer(Customer customer, Connection connection) {
        String query = "INSERT INTO customers ("
                + " id,"
                + " name,"
                + " country,"
                + ") VALUES ("
                + "null, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(2, customer.getName());
            statement.setString(3, customer.getCountry());
            statement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error(e);
        }
    }

    public void removeCustomer(Customer customer, Connection connection) {
        String query = "DELETE FROM customers WHERE name = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(2, customer.getName());
            statement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error(e);
        }
    }

    public void updateCustomer(Customer customer, Connection connection, int id) {
        String query = "UPDATE customers SET name = ?, site = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id);
            statement.setString(2, customer.getName());
            statement.setString(3, customer.getCountry());
            statement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error(e);
        }
    }

    public List<Customer> readCustomers(Connection connection) {
        List<Customer> list = new ArrayList<>();
        String query = "SELECT * FROM customers";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Customer customer = new Customer(
                        rs.getString(2),
                        rs.getString(3)
                );
                list.add(customer);
            }

        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return list;
    }
}
