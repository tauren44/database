package com.mateacademy;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DevelopersCrud {
    private static final Logger LOGGER = Logger.getLogger(DevelopersCrud.class);
    private static final String CREATE = "INSERT INTO developers (id, name, age, sex, salary,) VALUES (null, ?, ?, ?, ?)";;
    private static final String READ = "SELECT * FROM developers";
    private static final String UPDATE = "UPDATE developers SET name = ?, age = ?, sex = ?, salary = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM developers WHERE name = ?";

    public void addDeveloper(Developer developer, Connection connection) {
        try (PreparedStatement statement = connection.prepareStatement(CREATE)) {

            statement.setString(2, developer.getName());
            statement.setInt(3, developer.getAge());
            statement.setString(4, developer.getSex());
            statement.setInt(5, developer.getSalary());
            statement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error(e);
        }
    }

    public void removeDeveloper(Developer developer, Connection connection) {

        try (PreparedStatement statement = connection.prepareStatement(DELETE)) {

            statement.setString(2, developer.getName());
            statement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error(e);
        }
    }

    public void updateDeveloper(Developer developer, Connection connection, int id) {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE)) {

            statement.setInt(1, id);
            statement.setString(2, developer.getName());
            statement.setInt(3, developer.getAge());
            statement.setString(4, developer.getSex());
            statement.setInt(5, developer.getSalary());
            statement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error(e);
        }
    }

    public List<Developer> readDevelopers(Connection connection) {
        List<Developer> list = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(READ)) {
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Developer developer = new Developer(
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getInt(5)
                );
                list.add(developer);
            }

        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return list;
    }
}
