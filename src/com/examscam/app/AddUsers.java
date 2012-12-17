package com.examscam.app;

import java.util.Scanner;

import org.hibernate.HibernateException;

import com.examscam.HibernateUtil;
import com.examscam.dao.HibernateUserDAO;
import com.examscam.dao.UserDAO;
import com.examscam.model.User;

// Title: Hibernate Made Easy
// Author: Cameron McKenzie

// Page: 232 created AddUsers class

public class AddUsers {
    public static void main(String args[]) {
        int keepAdding = 1;
        while (keepAdding == 1) {
            Scanner keyboard = new Scanner(System.in);
            User user = new User();
            System.out.println("New user's login name?");
            user.setLoginName(keyboard.next());
            System.out.println("New user's email address?");
            user.setEmailAddress(keyboard.next());
            System.out.println("New user's password?");
            user.setPassword(keyboard.next());
            try {
                HibernateUtil.beginTransaction();
                UserDAO userDAO = new HibernateUserDAO();
                userDAO.create(user);
                HibernateUtil.commitTransaction();
                System.out.println("User successfully added.");
            } catch (HibernateException e) {
                e.printStackTrace();
                System.out.println("Database Insert Failed");
                System.out.println(e.getClass() + e.getMessage());
            }
            System.out.println("Continue? (1=y / 0=n)");
            keepAdding = keyboard.nextInt();
        }
    }
}
