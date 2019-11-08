package com.ecc.exercises.springexercise.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.HibernateException; 

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.ecc.exercises.springexercise.model.Role;
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
public class RoleServiceImpl implements RoleService {

	HibernateUtil hibernateUtil;
	Session session;
	Transaction transaction;

	@Autowired
	public RoleServiceImpl(HibernateUtil hibernateUtil) {
		this.hibernateUtil = hibernateUtil;
	}

	public boolean createRole(Role role) {
		session = hibernateUtil.getSessionFactory().openSession();
		boolean created = false;
		try {
			transaction = session.beginTransaction();
			session.save(role); 
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

	public boolean updateRole(Role role) {
		session = hibernateUtil.getSessionFactory().openSession();
		boolean updated = false;
		try {
			transaction = session.beginTransaction();
			session.update(role); 
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

	public boolean deleteRole(Role role) {
		removeRoleFromPersons(role);
		session = hibernateUtil.getSessionFactory().openSession();
		boolean deleted = false;
		try {
			transaction = session.beginTransaction();
			session.delete(role); 
			transaction.commit();
			deleted = true;
		} catch (HibernateException e) {
			if (transaction!=null) {
				transaction.rollback();
			} 
			e.printStackTrace();
		} finally {
			session.close(); 
		}
    	return deleted;
	}

	private boolean removeRoleFromPersons(Role role) {
		boolean removed = false;
    	session = hibernateUtil.getSessionFactory().openSession();
	    try {
	    	transaction = session.beginTransaction();
	    	CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
	        CriteriaQuery<Person> criteriaQuery = criteriaBuilder.createQuery(Person.class);
	        Root<Person> root = criteriaQuery.from(Person.class);
	        criteriaQuery.select(root);
	        Query<Person> query = session.createQuery(criteriaQuery);
	        List<Person> persons = query.getResultList();
	    	for (Person person : persons) {
	    		person.getRoles().remove(role);
	    	}
		    transaction.commit();
		    removed = true;
		} catch (HibernateException e) {
		    if (transaction!=null) {
		    	transaction.rollback();
		    }
		    e.printStackTrace(); 
	    } catch (Exception exception) {
	    	System.out.println(exception);
	    } finally {
	        session.close(); 
		}
		return removed;
	}

	public List<Role> getRolesAsList() {
    	List<Role> roles = new ArrayList<Role>();
    	session = hibernateUtil.getSessionFactory().openSession();
    	try {
	        transaction = session.beginTransaction();
	        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
	        CriteriaQuery<Role> criteriaQuery = criteriaBuilder.createQuery(Role.class);
	        Root<Role> root = criteriaQuery.from(Role.class);
	        criteriaQuery.select(root);
	        Query<Role> query = session.createQuery(criteriaQuery);
	        query.setCacheable(true);
	        roles = query.getResultList();
		} catch (HibernateException e) {
			if (transaction!=null) transaction.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
    	return roles;
    }

    public Role getRoleWithId(Integer roleId) {
    	session = hibernateUtil.getSessionFactory().openSession();
    	Role role = new Role();
	    try {
	        role = session.get(role.getClass(), roleId);
		} catch (HibernateException e) {
		    if (transaction!=null) {
		    	transaction.rollback();
		    }
		    e.printStackTrace(); 
	    } finally {
	        session.close(); 
		}
		return role;
    }
}