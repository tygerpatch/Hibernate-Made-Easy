package com.examscam.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.examscam.HibernateUtil;
import com.examscam.model.User;

// Title: Hibernate Made Easy
// Author: Cameron McKenzie

// Page: 210 created FindFirstFive class

public class FindFirstFive {
    public static void main(String args[]) {
        User user = new User();
        Session session = HibernateUtil.beginTransaction();
        Criteria criteria = session.createCriteria(User.class);
        criteria.setFirstResult(0);
        criteria.setMaxResults(5);
        List results = criteria.list();
        HibernateUtil.commitTransaction();
        for (int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i).toString());
        }
    }
}
