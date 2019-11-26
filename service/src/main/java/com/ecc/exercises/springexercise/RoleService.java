package com.ecc.exercises.springexercise.service;

import com.ecc.exercises.springexercise.model.dto.RoleDto;

import java.util.List;
import java.util.Optional;

public interface RoleService {
	
	public RoleDto saveRole(RoleDto roleDto);
	public List<RoleDto> getRolesAsList();
	public RoleDto getRoleById(Integer roleId);
	public void deleteRole(RoleDto roleDto);
	public void deleteRoleById(Integer roleId);
	public Object generateRolesReport(List<RoleDto> roleDtos);
}