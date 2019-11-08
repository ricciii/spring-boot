package com.ecc.exercises.springexercise.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Embeddable
public class Name {
	
	@NotNull
	@NotBlank(message="Required")
	@Column(name="last_name", nullable=false)
	private String lastName;
	
	@NotNull
	@NotBlank(message="Required")
	@Column(name="first_name", nullable=false)
	private String firstName;
	
	@NotNull
	@NotBlank(message="Required")
	@Column(name="middle_name", nullable=false)
	private String middleName;
	
	@Column(name="suffix", nullable=true)
	private String suffix;

	public Name(String lastName, String firstName, String middleName, String suffix) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.middleName = middleName;
		this.suffix = suffix;
	}

	public Name(String lastName, String firstName, String middleName) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.middleName = middleName;
	}

	public Name() {

	}

	public String getLastName() {
		return this.lastName;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public String getSuffix() {
		return this.suffix;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	@Override
	public String toString() {
		String string;
		string = lastName + " " + firstName + " " + middleName;
		if((suffix != null) && ("".equals(suffix))==false) {
			string += ", " + suffix;
		}
		return string;
	}
}