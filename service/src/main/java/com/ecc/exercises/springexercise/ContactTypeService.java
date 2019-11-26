package com.ecc.exercises.springexercise.service;

import com.ecc.exercises.springexercise.model.ContactType;
import com.ecc.exercises.springexercise.model.dto.ContactTypeDto;

import java.util.List;

public interface ContactTypeService {

	public List<ContactTypeDto> getContactTypesAsList();
}