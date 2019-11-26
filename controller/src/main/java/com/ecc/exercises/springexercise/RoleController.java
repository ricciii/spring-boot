package com.ecc.exercises.springexercise.controller;

import com.ecc.exercises.springexercise.model.Role;
import com.ecc.exercises.springexercise.model.dto.RoleDto;
import com.ecc.exercises.springexercise.service.RoleService;
import com.ecc.exercises.springexercise.util.EntityDtoConverter;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
@CrossOrigin
@RequestMapping(value = "/api/roles", produces="application/json")
public class RoleController {

	@Autowired
	RoleService roleService;
	
	public RoleController(RoleService roleService) {
		this.roleService = roleService;
	}

	@GetMapping(value = "")
	public ResponseEntity<List<RoleDto>> getRolesList() {
		return new ResponseEntity<>(roleService.getRolesAsList(), HttpStatus.OK);
	}

	@GetMapping(value = "/{roleId}")
	public ResponseEntity<RoleDto> getRole(@PathVariable("roleId") Integer roleId) {
		return new ResponseEntity<RoleDto>(roleService.getRoleById(roleId), HttpStatus.OK);
	}

	@DeleteMapping(value = "/{roleId}")
	public ResponseEntity deleteRole(@PathVariable("roleId") Integer roleId) {
		roleService.deleteRoleById(roleId);
		return new ResponseEntity(HttpStatus.OK);
	}

	@PostMapping(value="")
	public ResponseEntity<RoleDto> createRole(@RequestBody RoleDto roleDto) {
		return new ResponseEntity<RoleDto>(roleService.saveRole(roleDto), HttpStatus.CREATED);
	}

	@PatchMapping(value="/{roleId}")
	public ResponseEntity<RoleDto> updateRole(@PathVariable("roleId") Integer roleId, @RequestBody RoleDto roleDto) {
		roleDto.setId(roleId);
		return new ResponseEntity<RoleDto>(roleService.saveRole(roleDto), HttpStatus.OK);
	}

	@GetMapping(value = "/pdf")
	public ResponseEntity<Object> generateRolesReport(@RequestBody List<RoleDto> roleDtos) {
		return new ResponseEntity<Object>(roleService.generateRolesReport(roleDtos), HttpStatus.OK);
	}

}