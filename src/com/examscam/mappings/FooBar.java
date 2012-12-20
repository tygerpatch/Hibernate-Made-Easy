package com.examscam.mappings;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

import org.hibernate.Session;

import com.examscam.HibernateUtil;

// Title: Hibernate Made Easy
// Author: Cameron McKenzie

// Page: 278 complete FooBar class

@Entity
@Table(name = "bar")
@SecondaryTable(name = "foo")
public class FooBar {
	
    private int id;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
        
    private String fooName;
    
    @Column(table = "foo")
    public String getFooName() {
        return fooName;
    }
    
    public void setFooName(String fooName) {
        this.fooName = fooName;
    }
        
    private String barCode;
        
    public String getBarCode() {
        return barCode;
    }
    
    public void setBarCode(String barCode){
        this.barCode = barCode;
    }
        
    public static void main(String[] args){
        HibernateUtil.recreateDatabase();

        FooBar fb = new FooBar();
        fb.setBarCode("90210");
        fb.setFooName("ManChu");

        Session session = HibernateUtil.beginTransaction();
        session.save(fb);

        HibernateUtil.commitTransaction();
    }
}
