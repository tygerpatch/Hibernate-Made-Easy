package com.examscam.mappings;


// Title: Hibernate Made Easy
// Author: Cameron McKenzie

// Page: 282 created unannotated Thing class

public class Thing {

    private long id;
    private String name;

    /* A Thing has-a ThingDetail as an instance variable. */
    private ThingDetail thingDetail;

    public ThingDetail getThingDetail() {
        return thingDetail;
    }

    public void setThingDetail(ThingDetail detail) {
        this.thingDetail = detail;
    }

    /* The prinmary key id is defined only in the Thing class */
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        this.name = n;
    }
}
