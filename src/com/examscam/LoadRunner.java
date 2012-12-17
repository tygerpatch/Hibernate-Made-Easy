package com.examscam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.examscam.model.User;

// Title: Hibernate Made Easy
// Author: Cameron McKenzie

// Page: 119 start of LoadRunner class

public class LoadRunner {

    public static void callLoad() {
        AnnotationConfiguration config = new AnnotationConfiguration();
        config.addAnnotatedClass(User.class);

        SessionFactory factory = config.configure().buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        // load code will go here

        session.getTransaction().commit();
    }

    public static void callGet() {
        AnnotationConfiguration config = new AnnotationConfiguration();
        config.addAnnotatedClass(User.class);

        SessionFactory factory = config.configure().buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        // get code will go here

        session.getTransaction().commit();
    }

    public static void main(String[] args) {
        LoadRunner.callLoad();
        LoadRunner.callGet();
    }

}
