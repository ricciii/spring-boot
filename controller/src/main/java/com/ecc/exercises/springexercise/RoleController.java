package com.ecc.exercises.springexercise.controller;

import com.ecc.exercises.springexercise.model.Role;
import com.ecc.exercises.springexercise.service.RoleService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RequestMapping(value = "/roles")
public class RoleController {

	@Autowired
	RoleService roleService;
   	List<Role> roles;
	@GetMapping(value = "")
	public String roles() {
    	return "roles/list";
	}

	@GetMapping(value = "/list")
	public String listRoles() {
    	return "roles/list";
	}

	@PostMapping(value = "/create-role")
	public String createRole(Role role) {
    	return "roles/create-role";
	}
}