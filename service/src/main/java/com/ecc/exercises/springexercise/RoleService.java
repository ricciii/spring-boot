package com.ecc.exercises.springexercise.service;

import com.ecc.exercises.springexercise.model.Role;

import java.util.List;

public interface RoleService {

	public boolean createRole(Role role);
	public List<Role> getRolesAsList();
	public Role getRoleWithId(Integer roleId);
	public boolean updateRole(Role role);
	public boolean deleteRole(Role role);
}