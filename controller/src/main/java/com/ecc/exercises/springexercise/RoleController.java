package com.ecc.exercises.springexercise.controller;

import com.ecc.exercises.springexercise.model.Role;
import com.ecc.exercises.springexercise.service.RoleService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
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
@RequestMapping(value = "/roles")
public class RoleController {

	private static final String UPDATE_ROLE_FORM = "";

	@Autowired
	RoleService roleService;

	@GetMapping(value = "")
	public String listRoles(Model model) {
    	model.addAttribute("roles", roleService.getRolesAsList());
    	return "roles/roles-list";
	}

	@GetMapping(value = "/create-role")
	public String showCreateRoleForm(Role role) {
    	return "roles/create-role-form";
	}

	@PostMapping(value = "/create-role")
	public String createRole(@Valid Role role, BindingResult result, Model model) {
    	roleService.createRole(role);
    	return "redirect:" + role.getId() + "/role-information";
	}

	@GetMapping(value = "/{roleId}/update-role")
	public String showUpdateRoleForm(@PathVariable("roleId") int roleId, Model model) {
    	Role role = roleService.getRoleWithId(roleId);
    	model.addAttribute(role);
    	return "roles/update-role-form";
	}

	@PostMapping(value = "/{roleId}/update-role")
	public String updateRole(@Valid Role role, BindingResult result, @PathVariable("roleId") int roleId, Model model) {
    	role.setId(roleId);
    	roleService.updateRole(role);
    	return "redirect:/roles/" + role.getId() + "/role-information";
	}

	@GetMapping(value = "/{roleId}/delete-role")
	public String deleteRole(@PathVariable("roleId") int roleId, Model model) {
    	Role role = roleService.getRoleWithId(roleId);
    	roleService.deleteRole(role);
    	model.addAttribute("roles", roleService.getRolesAsList());
    	return "redirect:/roles";
	}

	@GetMapping(value = "/{roleId}/role-information")
	public String showRoleInformation(@PathVariable("roleId") int roleId, Model model) {
    	Role role = roleService.getRoleWithId(roleId);
    	model.addAttribute(role);
    	return "roles/role-information";
	}
}