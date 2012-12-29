package com.examscam.mappings;

import com.examscam.HibernateUtil;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.Session;

// Title: Hibernate Made Easy
// Author: Cameron McKenzie

// Page: 299 Interest class

@Entity
public class Interest {

    private CompoundKey id;
    private double rate;

    @Id
    public CompoundKey getId() {
        return id;
    }

    public void setId(CompoundKey id) {
        this.id = id;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public static void main(String[] args) {
        Interest rate = new Interest();
        rate.setRate(18.5);
        Long wayne = new Long(99);
        Long mario = new Long(88);
        CompoundKey key = new CompoundKey(wayne, mario);
        rate.setId(key);
        HibernateUtil.recreateDatabase();
        Session session = HibernateUtil.beginTransaction();
        session.save(rate);
        HibernateUtil.commitTransaction();
    }
}
