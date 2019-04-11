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
    private static final String CREATE = "INSERT INTO companies (id, name, site,) VALUES (null, ?, ?)";
    private static final String READ = "SELECT * FROM companies";
    private static final String UPDATE = "UPDATE companies SET name = ?, site = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM companies WHERE name = ?";
    
    public void addCompany(Company company, Connection connection) {
        try (PreparedStatement statement = connection.prepareStatement(CREATE)) {

            statement.setString(2, company.getName());
            statement.setString(3, company.getSite());
            statement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error(e);
        }
    }

    public void removeCompany(Company company, Connection connection) {
        try (PreparedStatement statement = connection.prepareStatement(DELETE)) {

            statement.setString(2, company.getName());
            statement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error(e);
        }
    }

    public void updateCompany(Company company, Connection connection, int id) {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE)) {

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

        try (PreparedStatement statement = connection.prepareStatement(READ)) {
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
