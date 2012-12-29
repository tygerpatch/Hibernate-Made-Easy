package com.examscam.mappings;

import com.examscam.HibernateUtil;
import javax.persistence.Entity;
import org.hibernate.Session;

// Title: Hibernate Made Easy
// Author: Cameron McKenzie

// Page: 309 Parent class
// Page: 313 add static void main method

@Entity
public class Child extends Parent {

    private String firstName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public static void main(String args[]) {
    	Ancestor ancestor = new Ancestor();
    	ancestor.setNationality("Korean");

    	Parent parent = new Parent();
    	parent.setNationality("Jewish");
    	parent.setLastName("Steinberg");

    	Child child = new Child();
    	child.setNationality("Irish");
    	child.setLastName("McKenzie");
    	child.setFirstName("Cameron");

    	Session session = HibernateUtil.beginTransaction();

    	session.save(ancestor);
    	session.save(parent);
    	session.save(child);

    	HibernateUtil.commitTransaction();
    }
}
