package com.ecc.exercises.springexercise.util;

import com.ecc.exercises.springexercise.model.Person;
import com.ecc.exercises.springexercise.model.Role;
import com.ecc.exercises.springexercise.model.Contact;
import com.ecc.exercises.springexercise.model.ContactType;
import com.ecc.exercises.springexercise.model.dto.PersonDto;
import com.ecc.exercises.springexercise.model.dto.RoleDto;
import com.ecc.exercises.springexercise.model.dto.ContactDto;
import com.ecc.exercises.springexercise.model.dto.ContactTypeDto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class EntityDtoConverterImpl implements EntityDtoConverter {

    public PersonDto personEntityToDto(Person person) {
    	PersonDto personDto = new PersonDto();
    	personDto.setId(person.getId());
    	personDto.setName(person.getName());
    	personDto.setAddress(person.getAddress());
    	personDto.setDateOfBirth(person.getDateOfBirth());
    	personDto.setGwa(person.getGwa());
    	personDto.setDateHired(person.getDateHired());
    	personDto.setCurrentlyEmployed(person.getCurrentlyEmployed());
    	if(person.getContacts() != null) {
    		personDto.setContacts(person.getContacts().stream().map(this::contactEntityToDto).collect(Collectors.toSet()));
    	} else {
    		personDto.setContacts(null);
    	}
    	if(person.getRoles() != null) {
    		personDto.setRoles(person.getRoles().stream().map(this::roleEntityToDto).collect(Collectors.toSet()));
    	} else {
    		personDto.setRoles(null);
    	}
    	return personDto;
    }

	public RoleDto roleEntityToDto(Role role) {
		RoleDto roleDto = new RoleDto();
		roleDto.setId(role.getId());
		roleDto.setName(role.getName());
		return roleDto;
	}

	public ContactDto contactEntityToDto(Contact contact) {
		ContactDto contactDto = new ContactDto();
		contactDto.setId(contact.getId());
		contactDto.setType(this.contactTypeEntityToDto(contact.getType()));
		contactDto.setInfo(contact.getInfo());
		return contactDto;
	}

	public ContactTypeDto contactTypeEntityToDto(ContactType type) {
		ContactTypeDto typeDto = new ContactTypeDto();
		typeDto.setId(type.getId());
		typeDto.setName(type.getName());
		return typeDto;
	}

	public List<ContactTypeDto> contactTypeEntitiesToDtos(List<ContactType> types) {
		if(types != null) {
    		return types.stream().map(this::contactTypeEntityToDto).collect(Collectors.toList());
    	} 
    	return null;
	}

	public Person personDtoToEntity(PersonDto personDto) {
		Person person = new Person();
		person.setId(personDto.getId());
    	person.setName(personDto.getName());
    	person.setAddress(personDto.getAddress());
    	person.setDateOfBirth(personDto.getDateOfBirth());
    	person.setGwa(personDto.getGwa());
    	person.setDateHired(personDto.getDateHired());
    	person.setCurrentlyEmployed(personDto.getCurrentlyEmployed());
    	if(personDto.getContacts() != null) {
    		person.setContacts(personDto.getContacts().stream().map(this::contactDtoToEntity).collect(Collectors.toSet()));
    	} else {
    		person.setContacts(null);
    	}
    	if(personDto.getRoles() != null) {
    		person.setRoles(personDto.getRoles().stream().map(this::roleDtoToEntity).collect(Collectors.toSet()));
    	} else {
    		person.setRoles(null);
    	}
    	return person;
	}

	public Role roleDtoToEntity(RoleDto roleDto) {
		Role role = new Role();
		role.setId(roleDto.getId());
		role.setName(roleDto.getName());
		return role;
	}

	public Contact contactDtoToEntity(ContactDto contactDto) {
		Contact contact = new Contact();
		contact.setId(contactDto.getId());
		contact.setType(this.contactTypeDtoToEntity(contactDto.getType()));
		contact.setInfo(contactDto.getInfo());
		return contact;
	}

	public ContactType contactTypeDtoToEntity(ContactTypeDto typeDto) {
		ContactType type = new ContactType();
		type.setId(typeDto.getId());
		type.setName(typeDto.getName());
		return type;
	}
}
