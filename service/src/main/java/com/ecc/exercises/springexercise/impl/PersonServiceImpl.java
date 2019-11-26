package com.ecc.exercises.springexercise.service;

import com.ecc.exercises.springexercise.model.Person;
import com.ecc.exercises.springexercise.model.dto.PersonDto;
import com.ecc.exercises.springexercise.model.dto.RoleDto;
import com.ecc.exercises.springexercise.model.dto.ContactDto;
import com.ecc.exercises.springexercise.repository.PersonRepository;
import com.ecc.exercises.springexercise.util.EntityDtoConverter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class PersonServiceImpl implements PersonService {

	private PersonRepository personRepository;
	private EntityDtoConverter converter;

	@Autowired
	public PersonServiceImpl(PersonRepository personRepository, EntityDtoConverter converter) {
		this.personRepository = personRepository;
		this.converter = converter;
	}

	public PersonDto createPerson(PersonDto personDto) {
		return converter.personEntityToDto(personRepository.save(converter.personDtoToEntity(personDto)));
	}

	public PersonDto updatePerson(PersonDto personDto) {
		Integer personId = personDto.getId();
		Person person = converter.personDtoToEntity(personDto);
		person.setContacts(personRepository.findById(personId).get().getContacts());
		return converter.personEntityToDto(personRepository.save(person));
	}

	public void deletePerson(PersonDto personDto) {
		personRepository.delete(converter.personDtoToEntity(personDto));
	}

	public void deletePersonById(Integer personId) {
		personRepository.deleteById(personId);
	}

	public List<PersonDto> getPersonsAsList() {
		return personRepository.findAll().stream().map(converter::personEntityToDto).collect(Collectors.toList());
    }

    public PersonDto getPersonWithId(Integer personId) {
    	Optional<Person> person = personRepository.findById(personId);
		if(person.isPresent()) {
			return converter.personEntityToDto(person.get());
		}
		return null;
    }

    public PersonDto assignRole(Integer personId, RoleDto roleDto) {
		Person person = personRepository.findById(personId).get();
		person.getRoles().add(converter.roleDtoToEntity(roleDto));
		return converter.personEntityToDto(personRepository.save(person));
	}

	public PersonDto removeRole(Integer personId, RoleDto roleDto) {
		Person person = personRepository.findById(personId).get();
		person.getRoles().remove(converter.roleDtoToEntity(roleDto));
		return converter.personEntityToDto(personRepository.save(person));
	}

	public PersonDto addContact(Integer personId, ContactDto contactDto) {
		Person person = personRepository.findById(personId).get();
		person.getContacts().add(converter.contactDtoToEntity(contactDto));
		return converter.personEntityToDto(personRepository.save(person));
	}

	public PersonDto removeContact(Integer personId, ContactDto contactDto) {
		Person person = personRepository.findById(personId).get();
		person.getContacts().remove(converter.contactDtoToEntity(contactDto));
		return converter.personEntityToDto(personRepository.save(person));
	}
}