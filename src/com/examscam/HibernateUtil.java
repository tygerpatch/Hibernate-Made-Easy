package com.examscam;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.examscam.model.User;

// Title: Hibernate Made Easy
// Author: Cameron McKenzie

// Page: 126 start of HibernateUtil
// Page: 126 getInitializedConfiguration method
// Page: 127 update getInitializedConfiguration method with reference to future classes
// Page: 128 recreateDatabase method

public class HibernateUtil {

    public static Configuration getInitializedConfiguration() {
        AnnotationConfiguration config = new AnnotationConfiguration();

        // add all of your JPA annotated classes here!!!
        config.addAnnotatedClass(User.class);

        // Future classes we will be creating.
        // Keep them commented out for now.

        //config.addAnnotatedClass(Snafu.class);
        //config.addAnnotatedClass(FooBar.class);
        //config.addAnnotatedClass(Thing.class);
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

}
