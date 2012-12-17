package com.examscam.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.examscam.HibernateUtil;
import com.examscam.model.User;

// Title: Hibernate Made Easy
// Author: Cameron McKenzie

// Page: 217 created UserHelper class

public class UserHelper {
    public static List findByCriterion(Criterion... criterion) {
        Session session = HibernateUtil.getSession();
        Criteria criteria = session.createCriteria(User.class);
        for (Criterion crit : criterion) {
            criteria.add(crit);
        }
        return criteria.list();
    }

    public static void main(String[] args) {
        Session session = HibernateUtil.beginTransaction();
        List results = UserHelper.findByCriterion(
                Restrictions.ge("id", (long)2),
                Restrictions.lt("id", (long)8),
                Restrictions.isNotNull("emailAddress"));
        HibernateUtil.commitTransaction();
        for (int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i).toString());
        }
    }
}
