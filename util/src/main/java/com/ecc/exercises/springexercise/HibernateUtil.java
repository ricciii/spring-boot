package com.ecc.exercises.springexercise.util;

import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;

public interface HibernateUtil {
	public SessionFactory getSessionFactory();
}