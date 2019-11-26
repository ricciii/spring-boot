package com.ecc.exercises.springexercise.util;

import com.ecc.exercises.springexercise.model.Person;
import com.ecc.exercises.springexercise.model.Role;
import com.ecc.exercises.springexercise.model.Contact;
import com.ecc.exercises.springexercise.model.ContactType;
import com.ecc.exercises.springexercise.model.dto.PersonDto;
import com.ecc.exercises.springexercise.model.dto.RoleDto;
import com.ecc.exercises.springexercise.model.dto.ContactDto;
import com.ecc.exercises.springexercise.model.dto.ContactTypeDto;
import java.util.List;

public interface EntityDtoConverter {
    
	public PersonDto personEntityToDto(Person person);
	public RoleDto roleEntityToDto(Role role);
	public ContactDto contactEntityToDto(Contact contact);
	public ContactTypeDto contactTypeEntityToDto(ContactType type);
	public Person personDtoToEntity(PersonDto personDto);
	public Role roleDtoToEntity(RoleDto roleDto);
	public Contact contactDtoToEntity(ContactDto contactDto);
	public ContactType contactTypeDtoToEntity(ContactTypeDto typeDto);
	public List<ContactTypeDto> contactTypeEntitiesToDtos(List<ContactType> types);
}
