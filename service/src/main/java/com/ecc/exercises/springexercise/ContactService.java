package com.ecc.exercises.springexercise.service;

import com.ecc.exercises.springexercise.model.Contact;
import com.ecc.exercises.springexercise.model.ContactType;

import java.util.List;

public interface ContactService {

	public List<ContactType> getContactTypesAsList();
	public boolean createContact(Contact contact);
}