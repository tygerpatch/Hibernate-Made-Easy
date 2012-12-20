package com.examscam.mappings;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.Session;

import com.examscam.HibernateUtil;

// Title: Hibernate Made Easy
// Author: Cameron McKenzie

// Page: 265 Snafu class

@Entity
public class Snafu {
    private long id;
    private String situation;
    
    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }
    
    public void setId(long id){
        this.id = id;
    }
    
    public String getSituation() {
        return situation;
    }
    
    public void setSituation(String situation){
        this.situation = situation;
    }
    
    /* main not required - just for testing */
    public static void main(String args[]) {
        HibernateUtil .recreateDatabase();
        
        Snafu snafu = new Snafu();
        snafu.setSituation("normal");
        
        Session session = HibernateUtil.beginTransaction();
        session.save(snafu);
        
        HibernateUtil.commitTransaction();
    }
}
