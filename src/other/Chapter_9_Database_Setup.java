package other;

import java.sql.Date;
import java.util.GregorianCalendar;

import org.hibernate.Session;

import com.examscam.HibernateUtil;
import com.examscam.model.User;

// Title: Hibernate Made Easy
// Author: Cameron McKenzie

// Page: 194, 195 code to setup user table with dummy data
// Note: Class and package name were not provided in the book

public class Chapter_9_Database_Setup {
    public static void main(String args[]) {
        Session session = HibernateUtil.beginTransaction();

        {
            User user = new User();
            user.setLoginName("mj");
            user.setPassword("abc123");
            user.setEmailAddress("mj@mcnz.com");
            user.setVerified(false);
            user.setLastAccessTime(new java.util.Date());
            user.setRegistrationDate(new GregorianCalendar(2006, 01, 01));
            session.saveOrUpdate(user);
        }

        {
            User user = new User();
            user.setLoginName("mario");
            user.setPassword("pass");
            user.setEmailAddress("mario@scja.ca");
            user.setVerified(true);
            user.setLastAccessTime(Date.valueOf("2008-1-1"));
            user.setRegistrationDate(new GregorianCalendar(2007, 01, 01));
            session.saveOrUpdate(user);
        }

        {
            User user = new User();
            user.setLoginName("sk8trgrl");
            user.setPassword("password");
            user.setEmailAddress("avril@scja.com");
            user.setVerified(false);
            user.setLastAccessTime(new java.util.Date());
            user.setRegistrationDate(new GregorianCalendar(2008, 01, 01));
            session.saveOrUpdate(user);
        }

        {
            User user = new User();
            user.setLoginName("ridley");
            user.setPassword("mypassword");
            user.setEmailAddress("getbent@scja.ca");
            user.setVerified(true);
            user.setLastAccessTime(new java.util.Date());
            user.setLastAccessTime(Date.valueOf("2006-10-5"));
            user.setRegistrationDate(new GregorianCalendar(2006, 05, 11));
            session.saveOrUpdate(user);
        }

        {
            User user = new User();
            user.setLoginName("kerrr");
            user.setPassword("pwd");
            user.setEmailAddress("sheehan@princessjava.com");
            user.setVerified(false);
            user.setLastAccessTime(Date.valueOf("2008-2-25"));
            user.setRegistrationDate(new GregorianCalendar(2007, 12, 12));
            session.saveOrUpdate(user);
        }

        {
            User user = new User();
            user.setLoginName("astra");
            user.setPassword("pwd");
            user.setEmailAddress("rabbit@princessjava.com");
            user.setVerified(false);
            user.setLastAccessTime(new java.util.Date());
            user.setRegistrationDate(new GregorianCalendar());
            session.saveOrUpdate(user);
        }

        {
            User user = new User();
            user.setLoginName("cameron");
            user.setPassword("90210");
            user.setEmailAddress("me@scwcd.com");
            user.setVerified(true);
            user.setLastAccessTime(Date.valueOf("2008-9-15"));
            user.setRegistrationDate(new GregorianCalendar(2008, 8, 12));
            session.saveOrUpdate(user);
        }

        {
            User user = new User();
            user.setLoginName("stephen");
            user.setPassword("low");
            user.setEmailAddress("stanley@pulpjava.com");
            user.setVerified(false);
            user.setLastAccessTime(Date.valueOf("2008-2-25"));
            user.setRegistrationDate(new GregorianCalendar(2008, 8, 12));
            session.saveOrUpdate(user);
        }

        {
            User user = new User();
            user.setLoginName("che");
            user.setPassword("password");
            user.setEmailAddress("ernesto@pulpjava.com");
            user.setVerified(true);
            user.setLastAccessTime(Date.valueOf("1999-7-26"));
            user.setRegistrationDate(new GregorianCalendar(1999, 3, 9));
            session.saveOrUpdate(user);
        }

        {
            User user = new User();
            user.setLoginName("remy");
            user.setPassword("password");
            user.setEmailAddress("rabbit@scja.com");
            user.setVerified(false);
            user.setLastAccessTime(new java.util.Date());
            user.setRegistrationDate(new GregorianCalendar(2007, 05, 21));
            session.saveOrUpdate(user);
        }

        HibernateUtil.commitTransaction();
    }
}
