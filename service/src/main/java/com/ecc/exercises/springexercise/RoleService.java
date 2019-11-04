package com.ecc.exercises.springexercise.service;

import com.ecc.exercises.springexercise.model.Role;

import java.util.List;

public interface RoleService {

	public boolean createRole(Object object);
	public List<Role> getRolesAsList();
	public Role getRoleWithId(Integer roleId);
	public boolean updateRole(Object object);
	public boolean deleteRole(Object object);
}