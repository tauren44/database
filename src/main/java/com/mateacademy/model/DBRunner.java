package com.mateacademy.model;

import com.mateacademy.model.entity.Project;
import com.mateacademy.model.repository.ProjectRepository;
import org.hibernate.SessionFactory;

public class DBRunner {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Project project = new Project();
        project.setDate("01.01.1991");
        project.setName("PROJECT");

        ProjectRepository rep = new ProjectRepository();

        rep.create(project);
        rep.close();
    }
}
