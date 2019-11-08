package com.ecc.exercises.springexercise.service;

import com.ecc.exercises.springexercise.model.Contact;
import com.ecc.exercises.springexercise.model.ContactType;
import com.ecc.exercises.springexercise.util.HibernateUtil;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.HibernateException; 

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.query.Query;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.lang.IllegalArgumentException;

@Service
public class ContactServiceImpl implements ContactService{

	HibernateUtil hibernateUtil;
	Session session;
	Transaction transaction;

	@Autowired
	public ContactServiceImpl(HibernateUtil hibernateUtil) {
		this.hibernateUtil = hibernateUtil;
	}

	public Contact getContactWithId(Integer contactId) {
    	session = hibernateUtil.getSessionFactory().openSession();
	    Contact contact = new Contact();
	    try {
	        contact = session.get(Contact.class, contactId);
		} catch (HibernateException e) {
		    if (transaction!=null) {
		    	transaction.rollback();
		    }
		    e.printStackTrace(); 
	    } finally {
	        session.close(); 
		}
		return contact;
    }

	public List<ContactType> getContactTypesAsList() {
		List<ContactType> types = new ArrayList<ContactType>();
    	session = hibernateUtil.getSessionFactory().openSession();
    	try {
	        transaction = session.beginTransaction();
	        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
	        CriteriaQuery<ContactType> criteriaQuery = criteriaBuilder.createQuery(ContactType.class);
	        Root<ContactType> root = criteriaQuery.from(ContactType.class);
	        criteriaQuery.select(root);
	        Query<ContactType> query = session.createQuery(criteriaQuery);
	        query.setCacheable(true);
	        types = query.getResultList();
		} catch (HibernateException e) {
			if (transaction!=null) transaction.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
    	return types;
	}
}