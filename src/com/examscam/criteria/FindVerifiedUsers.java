package com.examscam.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;

import com.examscam.HibernateUtil;
import com.examscam.model.User;

// Title: Hibernate Made Easy
// Author: Cameron McKenzie

// Page: 202 created FindVerifiedUsers class

public class FindVerifiedUsers {
    public static void main(String[] args) {
        User user = new User();
        user.setVerified(false);
        Example example = Example.create(user);
        Session session = HibernateUtil.beginTransaction();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(example);
        List results = criteria.list();
        HibernateUtil.commitTransaction();
        for (int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i).toString());
        }
    }
}
