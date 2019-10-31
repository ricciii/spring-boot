//package com.ecc.exercises.springexercise.service;

import com.ecc.exercises.springexercise.model.*;

import java.util.List;

public interface PersonService {
	
	public enum ListingOrder {
		DEFAULT, GWA, LASTNAME, DATEHIRED
	}

	public boolean createPerson();
	public void readPerson(Person person);
	public void readPersons();
	public boolean updatePerson();
	public Person updatePersonContacts(Person person);
	public Person updatePersonRoles(Person person);
	public boolean deletePerson(); 
		
}