package com.examscam.model;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

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
// Page: 145 explicitly name columns
// Page: 149 added transient encryptedPassword property
// Page: 150 updated main method to use encryptedPassword property
// Page: 152, 153 added emailAddress, verified, lastAccessTime, registrationDate fields
// Page: 154, 155 updated User class, added emailAddress

@Entity
@Table(name = "user", schema = "examscam")
public class User {

	private Long id;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private String password;

	@Column(name = "password")
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

	private String encryptedPassword;

	@Transient
	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	private Boolean verified;

	@Basic
	public Boolean isVerified() {
		return verified;
	}

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    private Date lastAccessTime;

    @Temporal(TemporalType.TIMESTAMP)
    public Date getLastAccessTime() {
        return lastAccessTime;
    }

    public void setLastAccessTime(Date lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    private Calendar registrationDate;

    @Temporal(TemporalType.DATE)
    public Calendar getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Calendar registrationDate) {
        this.registrationDate = registrationDate;
    }

    private String emailAddress;

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

	public static void main(String[] args) {
		Session session = HibernateUtil.beginTransaction();

		System.out.println("creating user");

		User user = new User();
		user.setPassword("abc123");
		user.setLoginName("mj");
		user.setEncryptedPassword("zab012");
		user.setEmailAddress("mj@scja.com");
		user.setLastAccessTime(new Date());
		user.setRegistrationDate(new GregorianCalendar());
		user.setVerified(false);

		session.save(user);

		System.out.println("user saved");
		HibernateUtil.commitTransaction();

		System.out.println("transaction successful");
	}
}
