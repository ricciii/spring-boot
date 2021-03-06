package com.ecc.exercises.springexercise.model;

import java.time.LocalDate;
import javax.persistence.Embeddable;
import javax.persistence.Column;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Embeddable
public class Address {
	
	@NotNull
	@Size(min=1, message="Short")
	@NotBlank(message="Required")
	@Column(name="street", nullable=true)
	private String street;
	
	@NotNull
	@NotBlank(message="Required")
	@Column(name="barangay", nullable=true)
	private String barangay;
	
	@NotNull
	@NotBlank(message="Required")
	@Column(name="municipality", nullable=true)
	private String municipality;
	
	@NotNull
	@NotBlank(message="Required")
	@Column(name="zip_code", nullable=true)
	private String zipCode;

	public Address(String street, String barangay, String municipality, String zipCode) {
		this.street = street;
		this.barangay = barangay;
		this.municipality = municipality;
		this.zipCode = zipCode;
	}

	public Address() {

	}

	public String getStreet() {
		return this.street;
	}

	public String getBarangay() {
		return this.barangay;
	}

	public String getMunicipality() {
		return this.municipality;
	}

	public String getZipCode() {
		return this.zipCode;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setBarangay(String barangay) {
		this.barangay = barangay;
	}

	public void setMunicipality(String municipality) {
		this.municipality = municipality;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String toString() {
		String string;
		string = street + ", " + barangay + ", " + municipality + ", " + zipCode;
		return string;
	}
}