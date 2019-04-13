package com.mateacademy;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectsCrud {
    private static final Logger LOGGER = Logger.getLogger(ProjectsCrud.class);
    private static final String CREATE = "INSERT INTO projects ( id, name, date,) VALUES (null, ?, ?)";
    private static final String READ = "SELECT * FROM projects";
    private static final String UPDATE = "UPDATE projects SET name = ?, site = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM projects WHERE name = ?";

    public void addProject(Project project, Connection connection) {
        try (PreparedStatement statement = connection.prepareStatement(CREATE)) {

            statement.setString(2, project.getName());
            statement.setString(3, project.getDate());
            statement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error(e);
        }
    }

    public void removeProject(Project project, Connection connection) {
        try (PreparedStatement statement = connection.prepareStatement(DELETE)) {

            statement.setString(2, project.getName());
            statement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error(e);
        }
    }

    public void updateProject(Project project, Connection connection, int id) {

        try (PreparedStatement statement = connection.prepareStatement(UPDATE)) {

            statement.setInt(1, id);
            statement.setString(2, project.getName());
            statement.setString(3, project.getDate());
            statement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error(e);
        }
    }

    public List<Project> readProjects(Connection connection) {
        List<Project> list = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(READ)) {
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Project project = new Project(
                        rs.getString(2),
                        rs.getString(3)
                );
                list.add(project);
            }

        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return list;
    }
}
