// package com.ecc.exercises.springexercise.service;

// import com.ecc.exercises.springexercise.model.Contact;
// import com.ecc.exercises.springexercise.model.ContactType;
// import com.ecc.exercises.springexercise.model.dto.ContactTypeDto;
// import com.ecc.exercises.springexercise.repository.ContactRepository;
// import com.ecc.exercises.springexercise.repository.ContactTypeRepository;
// import com.ecc.exercises.springexercise.util.EntityDtoConverter;

// import java.util.List;
// import java.util.stream.Collectors;

// import org.springframework.stereotype.Service;
// import org.springframework.beans.factory.annotation.Autowired;

// @Service
// public class ContactServiceImpl implements ContactService {

// 	private ContactRepository contactRepository;
// 	private ContactTypeRepository contactTypeRepository;
// 	private final EntityDtoConverter converter;

// 	@Autowired
// 	public ContactServiceImpl(ContactRepository contactRepository, 
// 		ContactTypeRepository contactTypeRepository, EntityDtoConverter converter) {
// 		this.contactRepository = contactRepository;
// 		this.contactTypeRepository = contactTypeRepository;
// 		this.converter = converter;
// 	}

// 	public Contact getContactWithId(Integer contactId) {
//     	return contactRepository.findById(contactId);
//     }

// 	public List<ContactType> getContactTypesAsList() {
//     	return contactTypeRepository.findAll();
// 	}

// 	public List<ContactTypeDto> getContactTypeDtosAsList() {
//     	return contactTypeRepository.findAll().stream().map(this.converter::contactTypeEntityToDto).collect(Collectors.toList());
// 	}
// }