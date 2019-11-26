package com.ecc.exercises.springexercise.service;

import com.ecc.exercises.springexercise.model.dto.PersonDto;
import com.ecc.exercises.springexercise.model.dto.RoleDto;
import com.ecc.exercises.springexercise.model.dto.ContactDto;

import java.util.List;

public interface PersonService {

	public PersonDto createPerson(PersonDto personDto);
	public PersonDto updatePerson(PersonDto personDto);
	public void deletePerson(PersonDto personDto);
	public void deletePersonById(Integer personId);
	public List<PersonDto> getPersonsAsList();
	public PersonDto getPersonWithId(Integer personId);
	public PersonDto assignRole(Integer personId, RoleDto roleDto);
	public PersonDto removeRole(Integer personId, RoleDto roleDto);
	public PersonDto addContact(Integer personId, ContactDto contactDto);
	public PersonDto removeContact(Integer personId, ContactDto contactDto);	
}