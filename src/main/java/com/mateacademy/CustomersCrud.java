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
    private static final String CREATE = "INSERT INTO customers ( id, name, country,) VALUES (null, ?, ?)";;
    private static final String READ = "SELECT * FROM customers";
    private static final String UPDATE = "UPDATE customers SET name = ?, site = ? WHERE id = ?";;
    private static final String DELETE = "DELETE FROM customers WHERE name = ?";

    public void addCustomer(Customer customer, Connection connection) {
        try (PreparedStatement statement = connection.prepareStatement(CREATE)) {

            statement.setString(2, customer.getName());
            statement.setString(3, customer.getCountry());
            statement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error(e);
        }
    }

    public void removeCustomer(Customer customer, Connection connection) {

        try (PreparedStatement statement = connection.prepareStatement(DELETE)) {

            statement.setString(2, customer.getName());
            statement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error(e);
        }
    }

    public void updateCustomer(Customer customer, Connection connection, int id) {

        try (PreparedStatement statement = connection.prepareStatement(UPDATE)) {

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

        try (PreparedStatement statement = connection.prepareStatement(READ)) {
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
