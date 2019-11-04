package com.ecc.exercises.springexercise.service;

import com.ecc.exercises.springexercise.model.Person;

import java.util.List;

public interface PersonService {
	
	// public enum ListingOrder {
	// 	DEFAULT, GWA, LASTNAME, DATEHIRED
	// }

	public boolean createPerson(Object object);
	public List<Person> getPersonsAsList();
		
}