package com.ecc.exercises.springexercise.model;

import java.time.LocalDate;
import javax.persistence.Embeddable;
import javax.persistence.Column;
import javax.persistence.*;

@Embeddable
public class Address {
	
	@Column(name="street", nullable=true)
	private String street;
	
	@Column(name="barangay", nullable=true)
	private String barangay;
	
	@Column(name="municipality", nullable=true)
	private String municipality;
	
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