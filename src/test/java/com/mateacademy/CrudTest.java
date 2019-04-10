package com.mateacademy;

import org.apache.log4j.Logger;
import org.junit.Test;
import java.sql.SQLException;



public class CrudTest {
    private static Logger logger = Logger.getLogger(CrudTest.class);
    private Crud crud = new Crud();

    @Test
    public void shouldCreateDataInDataBaseInChosenTable() {
        crud.createData("developers", "'FirstName SecondName', 20, 'male', 1550");
        try {
            crud.readData("developers");
        } catch (SQLException e) {
            logger.error(e);
        }
    }

    @Test
    public void shouldReadDataFromChosenTable() {
        try {
            crud.readData("skills");
        } catch (SQLException e) {
            logger.error(e);
        }
    }

    @Test
    public void shouldUpdateDataOnChosenTableAndColumnWithNewValueIfCondition() {
        crud.updateData("developers", "salary", "1660", "id = 7");
    }

    @Test
    public void shouldDeleteDataFromChosenTableIfCondition() {
        crud.deleteData("developers", "id = 15");
        try {
            crud.readData("developers");
        } catch (SQLException e) {
            logger.error(e);
        }
    }
}