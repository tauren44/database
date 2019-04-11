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

    public void addDeveloper(Developer developer, Connection connection) {
        String query = "INSERT INTO developers ("
                + " id,"
                + " name,"
                + " age,"
                + " sex,"
                + " salary,"
                + ") VALUES ("
                + "null, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {

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
        String query = "DELETE FROM developers WHERE name = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(2, developer.getName());
            statement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error(e);
        }
    }

    public void updateDeveloper(Developer developer, Connection connection, int id) {
        String query = "UPDATE developers SET name = ?, age = ?, sex = ?, salary = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {

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
        String query = "SELECT * FROM developers";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
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
