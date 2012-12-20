package com.examscam.mappings;

import javax.persistence.Embeddable;

// Title: Hibernate Made Easy
// Author: Cameron McKenzie

// Page: 283 created unannotated ThingDetail class
// Page: 284 added Embeddable annotation

@Embeddable
public class ThingDetail {

    private String alias;

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
