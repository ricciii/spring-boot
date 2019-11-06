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

	private static final String UPDATE_CREATE_FORM = "";

	@Autowired
	PersonService personService;
	@Autowired 
	RoleService roleService;

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
    	Person person = personService.getPersonWithId(personId);
    	model.addAttribute(person);
    	return "persons/update-person-form";
	}

	@PostMapping(value = "/{personId}/update-person")
	public String updatePerson(@Valid Person person, BindingResult result, @PathVariable("personId") int personId, Model model) {
    	person.setId(personId);
    	personService.updatePerson(person);
    	return "redirect:/persons/" + person.getId() + "/person-information";
	}

	@GetMapping(value = "/{personId}/person-information")
	public String showPersonInformation(@PathVariable("personId") int personId, Model model) {
    	Person person = personService.getPersonWithId(personId);
    	model.addAttribute(person);
    	return "persons/person-information";
	}

	// @GetMapping(value = "/roles/{roleId}/delete-role")
	// public String deletePerson(@PathVariable("personId") int personId, Model model) {
 //    	Role role = roleService.getRoleWithId(roleId);
 //    	roleService.deleteRole(role);
 //    	model.addAttribute("persons", personService.getPersonsAsList());
 //    	return "redirect:/persons";
	// }

	// @GetMapping(value = "/{personId}/add-contact")
	// public String showAddContactForm(@PathVariable("personId") int personId, Model model) {
 //    	Person person = personService.getPersonWithId(personId);
 //    	model.addAttribute(person);
 //    	return "persons/add-contact-form";
	// }

	// @PostMapping(value = "/{personId}/add-contact")
	// public String addContact(@Valid Person person, BindingResult result, @PathVariable("personId") int personId, Model model) {
 //    	person.setId(personId);
 //    	personService.updatePerson(person);
 //    	return "redirect:/persons/" + person.getId() + "/person-information";
	// }
}