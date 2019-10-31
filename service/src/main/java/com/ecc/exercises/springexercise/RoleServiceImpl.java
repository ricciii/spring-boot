package com.ecc.exercises.springexercise.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.HibernateException; 

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.ecc.exercises.springexercise.model.Role;
import com.ecc.exercises.springexercise.util.HibernateUtil;
import com.ecc.exercises.springexercise.util.HibernateUtilImpl;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	HibernateUtil hibernateUtil;
	Session session;
	Transaction transaction;

	// public RoleServiceImpl(HibernateUtil hibernateUtil) {
	// 	this.hibernateUtil = hibernateUtil;
	// }

	public boolean createRole(Object object) {
		session = hibernateUtil.getSessionFactory().openSession();
		boolean created = false;
		try {
			transaction = session.beginTransaction();
			session.save(object); 
			transaction.commit();
			created = true;
		} catch (HibernateException e) {
			if (transaction!=null) {
				transaction.rollback();
			} 
			e.printStackTrace();
		} finally {
			session.close(); 
		}
    	return created;
	}
}