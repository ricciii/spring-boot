package com.ecc.exercises.springexercise.service;

import com.ecc.exercises.springexercise.model.Role;
import com.ecc.exercises.springexercise.model.dto.RoleDto;
import com.ecc.exercises.springexercise.repository.RoleRepository;
import com.ecc.exercises.springexercise.util.EntityDtoConverter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

	private RoleRepository roleRepository;
	@Autowired
	private EntityDtoConverter converter;

	@Autowired
	public RoleServiceImpl(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	public RoleDto saveRole(RoleDto roleDto) {
    	return converter.roleEntityToDto(roleRepository.save(converter.roleDtoToEntity(roleDto)));
	}

	public void deleteRole(RoleDto roleDto) {
    	roleRepository.delete(converter.roleDtoToEntity(roleDto));
	}

	public void deleteRoleById(Integer roleId) {
    	roleRepository.deleteById(roleId);
	}

	public List<RoleDto> getRolesAsList() {
    	return roleRepository.findAll().stream().map(converter::roleEntityToDto).collect(Collectors.toList());
    }

    public RoleDto getRoleById(Integer roleId) {
		Optional<Role> role = roleRepository.findById(roleId);
		if(role.isPresent()) {
			return converter.roleEntityToDto(role.get());
		}
		return null;
    }

    public Object generateRolesReport(List<RoleDto> roleDtos) {
    	return new Object();
    }
}