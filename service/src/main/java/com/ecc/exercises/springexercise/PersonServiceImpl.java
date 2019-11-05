package com.ecc.exercises.springexercise.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.HibernateException; 

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.ecc.exercises.springexercise.model.Person;
import com.ecc.exercises.springexercise.util.HibernateUtil;

import java.util.List;
import java.util.ArrayList;

import org.hibernate.Criteria;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.query.Query;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.lang.IllegalArgumentException;

@Service
public class PersonServiceImpl implements PersonService {

	HibernateUtil hibernateUtil;
	Session session;
	Transaction transaction;

	@Autowired
	public PersonServiceImpl(HibernateUtil hibernateUtil) {
		this.hibernateUtil = hibernateUtil;
	}

	public boolean createPerson(Object object) {
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

	public boolean updatePerson(Object object) {
		session = hibernateUtil.getSessionFactory().openSession();
		boolean updated = false;
		try {
			transaction = session.beginTransaction();
			session.update(object); 
			transaction.commit();
			updated = true;
		} catch (HibernateException e) {
			if (transaction!=null) {
				transaction.rollback();
			} 
			e.printStackTrace();
		} finally {
			session.close(); 
		}
    	return updated;
	}

	public List<Person> getPersonsAsList() {
    	List<Person> persons = new ArrayList<Person>();
    	session = hibernateUtil.getSessionFactory().openSession();
    	try {
	        transaction = session.beginTransaction();
	        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
	        CriteriaQuery<Person> criteriaQuery = criteriaBuilder.createQuery(Person.class);
	        Root<Person> root = criteriaQuery.from(Person.class);
	        criteriaQuery.select(root);
	        Query<Person> query = session.createQuery(criteriaQuery);
	        query.setCacheable(true);
	        persons = query.getResultList();
		} catch (HibernateException e) {
			if (transaction!=null) transaction.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
    	return persons;
    }

    public Person getPersonWithId(Integer personId) {
    	session = hibernateUtil.getSessionFactory().openSession();
    	Person person = new Person();
	    try {
	        person = session.get(person.getClass(), personId);
		} catch (HibernateException e) {
		    if (transaction!=null) {
		    	transaction.rollback();
		    }
		    e.printStackTrace(); 
	    } finally {
	        session.close(); 
		}
		return person;
    }
}