package com.ecc.exercises.springexercise.model.dto;

import com.ecc.exercises.springexercise.model.Name;
import com.ecc.exercises.springexercise.model.Address;

import java.time.LocalDate;
import java.util.Set;

public class PersonDto extends BaseEntityDto {

	private Name name;
	private Address address;
	private LocalDate dateOfBirth;
	private float gwa;
	private LocalDate dateHired;
	private Boolean currentlyEmployed;
	private Set<ContactDto> contacts;
	private Set<RoleDto> roles;

	public PersonDto() {

	}

	public Name getName() {
		return this.name;
	}

	public Address getAddress() {
		return this.address;
	}

	public LocalDate getDateOfBirth() {
		return this.dateOfBirth;
	}

	public float getGwa() {
		return this.gwa;
	}

	public LocalDate getDateHired() {
		return this.dateHired;
	}

	public Boolean getCurrentlyEmployed() {
		return this.currentlyEmployed;
	}

	public Set<ContactDto> getContacts() {
		return this.contacts;
	}

	public Set<RoleDto> getRoles() {
		return this.roles;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setGwa(float gwa) {
		this.gwa = gwa;
	}

	public void setDateHired(LocalDate dateHired) {
		this.dateHired = dateHired;
	}

	public void setCurrentlyEmployed(Boolean currentlyEmployed) {
		this.currentlyEmployed = currentlyEmployed;
	}

	public void setContacts(Set contacts) {
		this.contacts = contacts;
	}

	public void setRoles(Set roles) {
		this.roles = roles;
	}
}