package com.examscam.mappings;

import javax.persistence.Entity;

// Title: Hibernate Made Easy
// Author: Cameron McKenzie

// Page: 309 Parent class

@Entity
public class Parent extends Ancestor {

    private String lastName;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
