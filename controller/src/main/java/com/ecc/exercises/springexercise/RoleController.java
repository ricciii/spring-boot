package com.ecc.exercises.springexercise.controller;

import com.ecc.exercises.springexercise.service.RoleService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping(value = "/roles")
public class RoleController {

	@Autowired
	RoleService roleService;
   
	@RequestMapping(value = "")
	public String role() {
    	return "roles";
	}

	@RequestMapping(value = "/new")
	public String createRole() {
    	return "roles";
	}
}