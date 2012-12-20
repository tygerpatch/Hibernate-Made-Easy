package com.examscam.mappings;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.Session;

import com.examscam.HibernateUtil;


// Title: Hibernate Made Easy
// Author: Cameron McKenzie

// Page: 282 created unannotated Thing class
// Page: 285 annotated Thing class
// Page: 287 added static main method

@Entity
public class Thing {

    /* A Thing has-a ThingDetail as an instance variable. */
    private ThingDetail thingDetail;

    @Embedded
    public ThingDetail getThingDetail() {
        return thingDetail;
    }

    public void setThingDetail(ThingDetail detail) {
        this.thingDetail = detail;
    }

    /* The prinmary key id is defined only in the Thing class */

    private long id;

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String n) {
        this.name = n;
    }

    public static void main(String[] args){
        /* recreateDatabase is need to ensure the Thing table is created */
        HibernateUtil.recreateDatabase();

        ThingDetail detail = new ThingDetail();
        detail.setAlias("Joey Shabidoo");
        detail.setCount(10);

        Thing thing = new Thing();
        thing.setName("Homer");
        thing.setThingDetail(detail);

        Session session = HibernateUtil.beginTransaction();
        /* only the instance of Thing is explicitly saved */
        session.save(thing);
        HibernateUtil.commitTransaction();
    }
}
