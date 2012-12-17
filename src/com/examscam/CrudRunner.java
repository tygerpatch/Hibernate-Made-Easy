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
// Page: 106 updated retrieve method with console output
// Page: 112 updateAll method

// CRUD = Create, Read, Update, and Delete
public class CrudRunner {

	public static void main(String[] args) {
		// Run all the static methods
		CrudRunner.create();
		CrudRunner.retrieve();
		CrudRunner.retrieveFromId(1);
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
		// your standard Hibernate connection code
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(User.class);

		SessionFactory factory = config.configure().buildSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();

		System.out.println("Querying the whole database...");

		Query queryResult = session.createQuery("from User");
		List allUsers = queryResult.list();

		System.out.println("Number of rows: " + allUsers.size());

		for (int i = 0; i < allUsers.size(); i++) {
			User user = (User) allUsers.get(i);
		}

		System.out.println("Database contents delivered...");

		session.getTransaction().commit();
	}

	public static User retrieveFromId(int idValue) {
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(User.class);
		SessionFactory factory = config.configure().buildSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		String queryString = "from User where id = :id";
		Query query = session.createQuery(queryString);
		query.setInteger("id", idValue);
		Object queryResult = query.uniqueResult();
		User user = (User) queryResult;
		session.getTransaction().commit();
		System.out.print(user.getPassword());
		return user;
	}

    public static void updateAll() {
        AnnotationConfiguration config = new AnnotationConfiguration();
        config.addAnnotatedClass(User.class);

        SessionFactory factory = config.configure().buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        System.out.println("Updating all records...");

        Query queryResult = session.createQuery("from USer");
        List allUsers = queryResult.list();

        System.out.println("# of rows: " + allUsers.size());

        for (int i = 0; i < allUsers.size(); i++) {
            User user = (User) allUsers.get(i);
            System.out.println(user);
            user.setPassword("password");
            session.update(user);
        }

        System.out.println("Database contents udpated...");

        session.getTransaction().commit();
    }

    public static void deleteAll() {
        AnnotationConfiguration config = new AnnotationConfiguration();
        config.addAnnotatedClass(User.class);

        SessionFactory factory = config.configure().buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        System.out.println("Deleting all records...");

        Query queryResult = session.createQuery("from User");
        List allUsers = queryResult.list();

        for (int i = 0; i < allUsers.size(); i++) {
            User user = (User) allUsers.get(i);
            System.out.println(user);
            session.delete(user);
        }

        System.out.println("Database contents deleted...");

        session.getTransaction().commit();
    }

}
