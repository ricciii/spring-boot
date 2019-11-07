package com.ecc.exercises.springexercise.controller;

import com.ecc.exercises.springexercise.model.Person;
import com.ecc.exercises.springexercise.service.PersonService;
import com.ecc.exercises.springexercise.service.RoleService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;

@Controller
@RequestMapping(value = "/persons")
public class PersonController {

	@Autowired
	PersonService personService;
	private Person person;

	@GetMapping(value = "")
	public String listPersons(Model model) {
    	model.addAttribute("persons", personService.getPersonsAsList());
    	return "persons/persons-list";
	}

	@GetMapping(value = "/create-person")
	public String showCreatePersonForm(Person person) {
    	return "persons/create-person-form";
	}

	@PostMapping(value = "/create-person")
	public String createPerson(@Valid Person person, BindingResult result, Model model) {
    	personService.createPerson(person);
    	return "redirect:/persons/" + person.getId() + "/person-information";
	}

	@GetMapping(value = "/{personId}/update-person")
	public String showUpdatePersonForm(@PathVariable("personId") int personId, Model model) {
    	this.person = personService.getPersonWithId(personId);
    	model.addAttribute(this.person);
    	return "persons/update-person-form";
	}

	@PostMapping(value = "/{personId}/update-person")
	public String updatePerson(@Valid Person person, BindingResult result, @PathVariable("personId") int personId, Model model) {
    	person.setId(personId);
    	person.setContacts(this.person.getContacts());
    	person.setRoles(this.person.getRoles());
    	personService.updatePerson(person);
    	return "redirect:/persons/" + person.getId() + "/person-information";
	}

	@GetMapping(value = "/{personId}/person-information")
	public String showPersonInformation(@PathVariable("personId") int personId, Model model) {
    	Person person = personService.getPersonWithId(personId);
    	model.addAttribute(person);
    	return "persons/person-information";
	}

	@GetMapping(value = "/{personId}/delete-person")
	public String deletePerson(@PathVariable("personId") int personId) {
    	Person person = personService.getPersonWithId(personId);
    	personService.deletePerson(person);
    	return "redirect:/persons";
	}
}