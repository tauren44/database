package com.mateacademy;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompaniesCrud {
    private static final Logger LOGGER = Logger.getLogger(CompaniesCrud.class);

    public void addCompany(Company company, Connection connection) {
        String query = "INSERT INTO companies ("
                + " id,"
                + " name,"
                + " site,"
                + ") VALUES ("
                + "null, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(2, company.getName());
            statement.setString(3, company.getSite());
            statement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error(e);
        }
    }

    public void removeCompany(Company company, Connection connection) {
        String query = "DELETE FROM companies WHERE name = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(2, company.getName());
            statement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error(e);
        }
    }

    public void updateCompany(Company company, Connection connection, int id) {
        String query = "UPDATE companies SET name = ?, site = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id);
            statement.setString(2, company.getName());
            statement.setString(3, company.getSite());
            statement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error(e);
        }
    }

    public List<Company> readCompanies(Connection connection) {
        List<Company> list = new ArrayList<>();
        String query = "SELECT * FROM companies";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Company company = new Company(
                        rs.getString(2),
                        rs.getString(3)
                );
                list.add(company);
            }

        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return list;
    }
}
