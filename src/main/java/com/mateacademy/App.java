package com.mateacademy;


public class App {
    public static void main(String[] args) {
        Crud crud = new Crud();
//        crud.createData("skills", "'Java', 'Test'");
//        crud.updateData("skills", "lvl", "'low'", "id = 15");
        crud.deleteData("skills", "id = 15");
    }
}
