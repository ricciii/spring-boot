package com.ecc.exercises.springexercise.controller;

import com.ecc.exercises.springexercise.model.Person;
import com.ecc.exercises.springexercise.model.Contact;
import com.ecc.exercises.springexercise.model.ContactType;

import com.ecc.exercises.springexercise.service.PersonService;
import com.ecc.exercises.springexercise.service.ContactService;

import java.util.List;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;

@Controller
@RequestMapping(value = "/persons/{personId}")
public class ContactController {

	@Autowired
	PersonService personService;
	@Autowired
	ContactService contactService;
	private Person person;

	@ModelAttribute("types")
	public List<ContactType> populateContactTypes() {
		return contactService.getContactTypesAsList();
	}

	@ModelAttribute("person")
    public Person getPerson(@PathVariable("personId") int personId) {
        return personService.getPersonWithId(personId);
    }

    @InitBinder("person")
    public void initPersonBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

	@GetMapping(value = "/add-contact")
	public String showAddContactForm(Person person, ModelMap model) {
    	Contact contact = new Contact();
    	person.getContacts().add(contact);
    	model.put("contact", contact);
    	return "persons/add-contact-form";
	}

	@PostMapping(value = "/add-contact")
	public String addContact(Person person, @Valid Contact contact, BindingResult result, ModelMap model) {
    	person.getContacts().add(contact);
    	personService.updatePerson(person);
    	return "redirect:/persons/" + person.getId() + "/person-information";
	}

	@GetMapping(value = "/person-information/{contactId}/delete-contact")
	public String deleteContact(@PathVariable("personId") int personId, @PathVariable("contactId") int contactId) {
    	Contact contact = contactService.getContactWithId(contactId);
    	Person person = personService.getPersonWithId(personId);
    	person.getContacts().remove(contact);
    	personService.updatePerson(person);
    	return "redirect:/persons/" + person.getId() + "/person-information";
	}
}