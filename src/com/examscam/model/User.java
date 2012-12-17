package com.examscam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.Session;

import com.examscam.HibernateUtil;

// Title: Hibernate Made Easy
// Author: Cameron McKenzie

// Page  62 Created User Pojo without JPA Annotations
// Page: 64 Added JPA Annotation to User Pojo
// Page: 73 Added static main method to User Pojo
// Page: 84 Commented out SchemaExport Call
// Page: 85 Created transient User instance
// Page: 86 Created SessionFactory object
// Page: 88 Created Session object
// Page: 89 Added begin & end transaction block
// Page: 90 Able to save a simple POJO to Hibernate
// Page: 137 updated User to use HibernateUtil
// Page: 141 added loginName property
// Page: 142 updated main method to use loginName

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

	private String loginName;

	@Column(name = "login_name")
	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName){
		this.loginName = loginName;
	}

	public static void main(String[] args) {
		Session session = HibernateUtil.beginTransaction();

		System.out.println("creating user");

		User user = new User();
		user.setPassword("abc123");
		user.setLoginName("mj");

		session.save(user);

		System.out.println("user saved");
		HibernateUtil.commitTransaction();

		System.out.println("transaction successful");
	}
}
