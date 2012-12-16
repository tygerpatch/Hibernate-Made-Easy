package com.examscam.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

// Title: Hibernate Made Easy
// Author: Cameron McKenzie
// Page  62 Created User Pojo without JPA Annotations
// Page: 64 Added JPA Annotation to User Pojo
// Page: 73 Added static main method to User Pojo
// Page: 84 Commented out SchemaExport Call
// Page: 85 Created transient User instance

@Entity
public class User {

	private Long id;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static void main(String[] args) {
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(User.class);
		config.configure();
		// new SchemaExport(config).create(true, true);
		
		// This User instance, u, is completely transient.
		// Hibernate is not aware of it, nor does Hibernate care about it.
		User user = new User();
		user.setPassword("abc123");
	}
}
// As the User instance goes out of scope, it is garbage collected,
// and it's state is not persisted.
