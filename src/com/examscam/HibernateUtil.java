package com.examscam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.examscam.hib.exam.Exam;
import com.examscam.hib.exam.ExamDetail;
import com.examscam.mappings.Child;
import com.examscam.mappings.FooBar;
import com.examscam.mappings.Fracture;
import com.examscam.mappings.Interest;
import com.examscam.mappings.Prison;
import com.examscam.mappings.Snafu;
import com.examscam.mappings.Thing;
import com.examscam.model.User;

// Title: Hibernate Made Easy
// Author: Cameron McKenzie

// Page: 126 start of HibernateUtil
// Page: 126 getInitializedConfiguration method
// Page: 127 update getInitializedConfiguration method with reference to future classes
// Page: 128 recreateDatabase method
// Page: 128 static void main method
// Page: 129 getSession method
// Page: 131 beginTransaction method
// Page: 131 commitTransaction method
// Page: 132 closeSession method
// Page: 133 rollbackTransaction
// Page: 268 uncommented line adding Snafu to AnnotationConfiguration object
// Page: 279 uncommented line adding FooBar to AnnotationConfiguration object
// Page: 288 uncommented line adding Thing to AnnotationConfiguration object
// Page: 300 added Interest class to AnnotationConfiguration object
// Page: 303 added Fracture class to AnnotationConfiguration object
// Page: 305 added Prison class to AnnotationConfiguration object

public class HibernateUtil {

    public static Configuration getInitializedConfiguration() {
        AnnotationConfiguration config = new AnnotationConfiguration();

        // add all of your JPA annotated classes here!!!
        config.addAnnotatedClass(User.class);

        // Future classes we will be creating.
        // Keep them commented out for now.

        config.addAnnotatedClass(Snafu.class);
        config.addAnnotatedClass(FooBar.class);
        config.addAnnotatedClass(Thing.class);
        config.addAnnotatedClass(Interest.class);
        config.addAnnotatedClass(Fracture.class);
        config.addAnnotatedClass(Prison.class);
        config.addAnnotatedClass(Child.class);
        config.addAnnotatedClass(Exam.class);
        config.addAnnotatedClass(ExamDetail.class);

        //config.addAnnotatedClass(Team.class);
        //config.addAnnotatedClass(Player.class);
        //config.addAnnotatedClass(RightManyCourse.class);
        //config.addAnnotatedClass(LeftManyStudent.class);

        config.configure();
        return config;
    }

    public static void recreateDatabase() {
        Configuration config = HibernateUtil.getInitializedConfiguration();
        new SchemaExport(config).create(true, true);
    }

    public static void main(String[] args) {
        HibernateUtil.recreateDatabase();
    }

    private static SessionFactory factory;

    public static Session getSession() {
        if (factory == null) {
            Configuration config = HibernateUtil.getInitializedConfiguration();
            factory = config.buildSessionFactory();
        }

        Session hibernateSession = factory.getCurrentSession();
        return hibernateSession;
    }

    public static Session beginTransaction() {
        Session hibernateSession = HibernateUtil.getSession();
        hibernateSession.beginTransaction();
        return hibernateSession;
    }

    public static void commitTransaction() {
        HibernateUtil.getSession().getTransaction().commit();
    }

    public static void closeSession() {
        HibernateUtil.getSession().close();
    }

    public static void rollbackTransaction() {
        HibernateUtil.getSession().getTransaction().rollback();
    }

}
