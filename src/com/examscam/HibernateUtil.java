package com.examscam;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.examscam.model.User;

// Title: Hibernate Made Easy
// Author: Cameron McKenzie

// Page: 126 start of HibernateUtil
// Page: 126 getInitializedConfiguration method

public class HibernateUtil {

    public static Configuration getInitializedConfiguration() {
        AnnotationConfiguration config = new AnnotationConfiguration();

        // add all of your JPA annotated classes here!!!
        config.addAnnotatedClass(User.class);
        config.configure();
        return config;
    }

}
