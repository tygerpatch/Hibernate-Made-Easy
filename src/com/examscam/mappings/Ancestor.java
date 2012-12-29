package com.examscam.mappings;

import com.examscam.HibernateUtil;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import org.hibernate.Session;

// Title: Hibernate Made Easy
// Author: Cameron McKenzie

// Page: 309 Ancestor class
// Page: 312 added Single Table Inheritance Strategy

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Ancestor {
    private Long id;
    private String nationality;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public static void main(String[] args) {
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
