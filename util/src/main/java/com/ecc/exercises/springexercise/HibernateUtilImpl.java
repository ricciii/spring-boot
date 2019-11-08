package com.ecc.exercises.springexercise.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.springframework.stereotype.Component;

@Component
public class HibernateUtilImpl implements HibernateUtil {
    private static SessionFactory sessionFactory;

	static {
		try {
	        sessionFactory = new Configuration().configure().buildSessionFactory();
	    } catch (Throwable ex) { 
	        System.err.println("Failed to create sessionFactory object." + ex);
	        throw new ExceptionInInitializerError(ex); 
	    }
	}

	public SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}
}
