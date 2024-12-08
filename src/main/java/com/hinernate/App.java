package com.hinernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Configuration cfg = null;
        SessionFactory sessionFactory = null; 
        Session session = null;
        Employee emp = null;
        Transaction tx = null;
        
        cfg = new Configuration();
        cfg.configure("/com/hinernate/hibernate.cfg.xml");
        
        sessionFactory = cfg.buildSessionFactory();
        
        session =sessionFactory.openSession();
        emp = new Employee();
        emp.setId(5);
        emp.setFirstName("Ravi");
        emp.setLastName("Yadav");
        emp.setSalary(20000);
        
        try {
        	tx = session.beginTransaction();
        	session.save(emp);
        	tx.commit();
        	
        }catch(HibernateException e) {
        	e.printStackTrace();
        }finally {
        	session.close();
        	sessionFactory.close();
        }
        
    }
}
