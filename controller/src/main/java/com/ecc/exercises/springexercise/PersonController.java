package com.ecc.exercises.springexercise.controller;

import com.ecc.exercises.springexercise.model.Person;
import com.ecc.exercises.springexercise.model.dto.PersonDto;
import com.ecc.exercises.springexercise.model.dto.RoleDto;
import com.ecc.exercises.springexercise.model.dto.ContactDto;
import com.ecc.exercises.springexercise.service.PersonService;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;

@RestController
@RequestMapping(value = "api/persons")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
    	this.personService = personService;
    }

    @GetMapping(value = "")
    public ResponseEntity<List<PersonDto>> getPersonsList() {
        return new ResponseEntity<List<PersonDto>>(personService.getPersonsAsList(), HttpStatus.OK);
    }

    @GetMapping(value = "/{personId}")
	public ResponseEntity<PersonDto> getPerson(@PathVariable("personId") Integer personId) {
		return new ResponseEntity<PersonDto>(personService.getPersonWithId(personId), HttpStatus.OK);
	}

	@DeleteMapping(value = "/{personId}")
	public ResponseEntity deletePerson(@PathVariable("personId") Integer personId) {
		personService.deletePersonById(personId);
		return new ResponseEntity(HttpStatus.OK);
	}

	@PostMapping(value="")
	public ResponseEntity<PersonDto> createPerson(@RequestBody PersonDto personDto) {
		return new ResponseEntity<PersonDto>(personService.createPerson(personDto), HttpStatus.CREATED);
	}

	@PutMapping(value="/{personId}")
	public ResponseEntity<PersonDto> updatePerson(@PathVariable("personId") Integer personId, @RequestBody PersonDto personDto) {
		personDto.setId(personId);
		return new ResponseEntity<PersonDto>(personService.updatePerson(personDto), HttpStatus.OK);
	}

	@PutMapping(value="/{personId}/assign-role")
	public ResponseEntity<PersonDto> assignRole(@PathVariable("personId") Integer personId, @RequestBody RoleDto roleDto) {
		return new ResponseEntity<PersonDto>(personService.assignRole(personId, roleDto), HttpStatus.OK);
	}

	@PutMapping(value="/{personId}/remove-role")
	public ResponseEntity<PersonDto> removeRole(@PathVariable("personId") Integer personId, @RequestBody RoleDto roleDto) {
		return new ResponseEntity<PersonDto>(personService.removeRole(personId, roleDto), HttpStatus.OK);
	}

	@PutMapping(value="/{personId}/add-contact")
	public ResponseEntity<PersonDto> addContact(@PathVariable("personId") Integer personId, @RequestBody ContactDto contactDto) {
		return new ResponseEntity<PersonDto>(personService.addContact(personId, contactDto), HttpStatus.OK);
	}

	@PutMapping(value="/{personId}/remove-contact")
	public ResponseEntity<PersonDto> removeContact(@PathVariable("personId") Integer personId, @RequestBody ContactDto contactDto) {
		return new ResponseEntity<PersonDto>(personService.removeContact(personId, contactDto), HttpStatus.OK);
	}
}