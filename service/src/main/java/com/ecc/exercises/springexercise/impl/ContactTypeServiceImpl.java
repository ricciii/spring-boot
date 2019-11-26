package com.ecc.exercises.springexercise.service;

import com.ecc.exercises.springexercise.model.dto.ContactTypeDto;
import com.ecc.exercises.springexercise.repository.ContactTypeRepository;
import com.ecc.exercises.springexercise.util.EntityDtoConverter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ContactTypeServiceImpl implements ContactTypeService {

	private ContactTypeRepository contactTypeRepository;
	private final EntityDtoConverter converter;

	@Autowired
	public ContactTypeServiceImpl(ContactTypeRepository contactTypeRepository, EntityDtoConverter converter) {
		this.contactTypeRepository = contactTypeRepository;
		this.converter = converter;
	}

	public List<ContactTypeDto> getContactTypesAsList() {
    	return converter.contactTypeEntitiesToDtos(contactTypeRepository.findAll());
	}
}