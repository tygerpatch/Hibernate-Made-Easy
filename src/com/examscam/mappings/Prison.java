package com.examscam.mappings;

import com.examscam.HibernateUtil;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import org.hibernate.Session;

// Title: Hibernate Made Easy
// Author: Cameron McKenzie

// Page: 304 Prison class

@Entity
public class Prison {
    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    private CompoundKey id;

    @EmbeddedId
    public CompoundKey getId() {
        return id;
    }

    public void setId(CompoundKey id) {
        this.id = id;
    }

    public static void main(String[] args) {
        Prison jail = new Prison();
        jail.setCity("Milhaven");
        Long wayne = new Long(99);
        Long mario = new Long(88);
        CompoundKey key = new CompoundKey(wayne, mario);
        jail.setId(key);
        HibernateUtil.recreateDatabase();
        Session session = HibernateUtil.beginTransaction();
        session.save(jail);
        HibernateUtil.commitTransaction();
    }
}
