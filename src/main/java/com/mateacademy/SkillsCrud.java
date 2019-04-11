package com.mateacademy;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SkillsCrud {
    private static final Logger LOGGER = Logger.getLogger(SkillsCrud.class);
    private static final String CREATE = "INSERT INTO skills ( id, skill, lvl,) VALUES (null, ?, ?)";
    private static final String READ = "SELECT * FROM skills";
    private static final String UPDATE  = "UPDATE skills SET name = ?, site = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM skills WHERE name = ?";

    public void addSkill(Skill skill, Connection connection) {
        try (PreparedStatement statement = connection.prepareStatement(CREATE)) {

            statement.setString(2, skill.getSkill());
            statement.setString(3, skill.getLvl());
            statement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error(e);
        }
    }

    public void removeSkill(Skill skill, Connection connection) {

        try (PreparedStatement statement = connection.prepareStatement(DELETE)) {

            statement.setString(2, skill.getSkill());
            statement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error(e);
        }
    }

    public void updateSkill(Skill skill, Connection connection, int id) {

        try (PreparedStatement statement = connection.prepareStatement(UPDATE)) {

            statement.setInt(1, id);
            statement.setString(2, skill.getSkill());
            statement.setString(3, skill.getLvl());
            statement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error(e);
        }
    }

    public List<Skill> readSkills(Connection connection) {
        List<Skill> list = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(READ)) {
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Skill skill = new Skill(
                        rs.getString(2),
                        rs.getString(3)
                );
                list.add(skill);
            }

        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return list;
    }
}
