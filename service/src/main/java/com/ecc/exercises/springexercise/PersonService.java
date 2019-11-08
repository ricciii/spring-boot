package com.ecc.exercises.springexercise.service;

import com.ecc.exercises.springexercise.model.Person;

import java.util.List;

public interface PersonService {
	
	// public enum ListingOrder {
	// 	DEFAULT, GWA, LASTNAME, DATEHIRED
	// }

	public boolean createPerson(Person person);
	public boolean deletePerson(Person person);
	public List<Person> getPersonsAsList();
	public boolean updatePerson(Person person);
	public Person getPersonWithId(Integer personId);
		
}