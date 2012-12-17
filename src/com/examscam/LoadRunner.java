package com.examscam;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.examscam.model.User;

// Title: Hibernate Made Easy
// Author: Cameron McKenzie

// Page: 119 start of LoadRunner class
// Page: 123 complete LoadRunner class code

public class LoadRunner {

	public static void callLoad() {
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(User.class);

		SessionFactory factory = config.configure().buildSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();

		try {
			User user = (User) session.load(User.class, new Long(1));
			System.out.println(user.getPassword());
		} catch (ObjectNotFoundException e) {
			e.printStackTrace();
		}

		session.getTransaction().commit();
		// System.out.println(user.getPassword()); // fails
	}

	public static void callGet() {
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(User.class);

		SessionFactory factory = config.configure().buildSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();

        User user = (User) session.get(User.class, new Long(1));
        System.out.println(user.getPassword());

		session.getTransaction().commit();
        System.out.println(user.getPassword());  // no problem
	}

	public static void main(String[] args) {
		LoadRunner.callLoad();
		LoadRunner.callGet();
	}

}
