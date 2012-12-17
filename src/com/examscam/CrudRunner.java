package com.examscam;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.examscam.model.User;

// Title: Hibernate Made Easy
// Author: Cameron McKenzie

// Page: 101 start of CrudRunner class
// Page: 102 retrieve method

// CRUD = Create, Read, Update, and Delete
public class CrudRunner {

    public static void main(String[] args) {
        // Run all the static methods (currently only 1)
        CrudRunner.create();
    }

    public static void create() {
        // Create the config object, reading from the hibernate.cfg.xml file.
        AnnotationConfiguration config = new AnnotationConfiguration();

        // Make sure all annotated classes are added to the configuration.
        config.addAnnotatedClass(User.class);
        SessionFactory factory;

        // Obtain the SessionFactory after calling the config() method
        // of the nnotationConfiguration instance.
        factory = config.configure().buildSessionFactory();

        // Get a Hibernate Session
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        // Create and initialize an instance of a JPA annotated class.
        User user = new User();
        user.setPassword("abc123");

        // Have the instance touch the session and then commit the transaction.
        session.save(user);
        session.getTransaction().commit();
    }

    public static void retrieve() {
        AnnotationConfiguration config = new AnnotationConfiguration();
        config.addAnnotatedClass(User.class);
        SessionFactory factory = config.configure().buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Query queryResult = session.createQuery("from User");
        List allUsers = queryResult.list();
        for (int i = 0; i < allUsers.size(); i++) {
            User user = (User) allUsers.get(i);
        }
        session.getTransaction().commit();
    }

}
