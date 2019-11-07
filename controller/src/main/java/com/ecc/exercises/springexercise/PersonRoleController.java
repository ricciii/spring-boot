package com.ecc.exercises.springexercise.controller;

import com.ecc.exercises.springexercise.model.Person;
import com.ecc.exercises.springexercise.model.Role;

import com.ecc.exercises.springexercise.service.PersonService;
import com.ecc.exercises.springexercise.service.RoleService;

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
public class PersonRoleController {

	@Autowired
	PersonService personService;
	@Autowired
	RoleService roleService;

	@ModelAttribute("roles")
	public List<Role> populateAvailableRoles() {
		return roleService.getRolesAsList();
	}

	@ModelAttribute("person")
    public Person getPerson(@PathVariable("personId") int personId) {
        return personService.getPersonWithId(personId);
    }

    @InitBinder("person")
    public void initPersonBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

	@GetMapping(value = "/assign-role")
	public String showAssignRoleForm(Person person, ModelMap model) {
    	Role role = new Role();
    	person.getRoles().add(role);
    	model.put("role", role);
    	return "persons/assign-role-form";
	}

	@PostMapping(value = "/assign-role")
	public String assignRole(Person person, @Valid Role role, BindingResult result, ModelMap model) {
    	person.getRoles().add(roleService.getRoleWithId(role.getId()));
    	personService.updatePerson(person);
    	return "redirect:/persons/" + person.getId() + "/person-information";
	}

	@GetMapping(value = "/person-information/{roleId}/delete-role")
	public String deletePersonRole(@PathVariable("personId") int personId, @PathVariable("roleId") int roleId) {
    	Role role = roleService.getRoleWithId(roleId);
    	Person person = personService.getPersonWithId(personId);
    	person.getRoles().remove(role);
    	personService.updatePerson(person);
    	return "redirect:/persons/" + person.getId() + "/person-information";
	}
}