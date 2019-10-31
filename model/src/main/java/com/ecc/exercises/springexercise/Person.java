package com.ecc.exercises.springexercise.model;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Type;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name="person")
public class Person extends BaseEntity implements Comparable<Person> {
	
	@Embedded
	private Name name;
	
	@Embedded
	private Address address;
	
	@Type(type="calendar_date")
	@Column(name="date_of_birth", nullable=true)
	private Calendar dateOfBirth;
	
	@Column(name="gwa", nullable=true)
	private float gwa;
	
	@Type(type="calendar_date")
	@Column(name="date_hired", nullable=true)
	private Calendar dateHired;
	
	@Column(name="currently_employed", nullable=true)
	private Boolean currentlyEmployed;
	
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@OneToMany(fetch=FetchType.LAZY, cascade = { CascadeType.ALL }, targetEntity=Contact.class, orphanRemoval=true)
	//@Fetch(FetchMode.JOIN)
	@JoinColumn(name="person_id")
	@BatchSize(size=5)
	private Set contacts;
	
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@ManyToMany(fetch=FetchType.LAZY, cascade = { CascadeType.PERSIST,  CascadeType.MERGE }, targetEntity=Role.class)
	//@Fetch(FetchMode.JOIN)
	@BatchSize(size=5)
	@JoinTable(name = "person_role", joinColumns = { @JoinColumn(name = "person_id") }, 
		inverseJoinColumns = { @JoinColumn(name = "role_id") })
	private Set roles;

	public Person() {

	}

	public Person(Name name, Address address, Calendar dateOfBirth, float gwa, 
   	Calendar dateHired, Boolean currentlyEmployed) {
   		this.name = name;
   		this.address = address;
   		this.dateOfBirth = dateOfBirth;
   		this.gwa = gwa;
   		this.dateHired = dateHired;
   		this.currentlyEmployed = currentlyEmployed;
	}

	public Name getName() {
		return this.name;
	}

	public Address getAddress() {
		return this.address;
	}

	public Calendar getDateOfBirth() {
		return this.dateOfBirth;
	}

	public float getGwa() {
		return this.gwa;
	}

	public Calendar getDateHired() {
		return this.dateHired;
	}

	public Boolean getCurrentlyEmployed() {
		return this.currentlyEmployed;
	}

	public Set getContacts() {
		return this.contacts;
	}

	public Set getRoles() {
		return this.roles;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setDateOfBirth(Calendar dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setGwa(float gwa) {
		this.gwa = gwa;
	}

	public void setDateHired(Calendar dateHired) {
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

	@Override
	public String toString() {
		String string;
		string = "ID: " + super.getId() + "\n"; 
		string += "Name: " + name + "\n";
		string += "Address: "+ address + "\n";
		string += "Date Of Birth: " + dateOfBirth.get(Calendar.YEAR) + "-" + dateOfBirth.get(Calendar.MONTH) + "-" + dateOfBirth.get(Calendar.DATE) + "\n";
		string += "GWA: " + gwa + "\n";
		string += "Date Hired: " + dateHired.get(Calendar.YEAR) + "-" + dateHired.get(Calendar.MONTH) + "-" + dateHired.get(Calendar.DATE) + "\n";
		string += "Currently Employed: " + currentlyEmployed + "\n";
		string += "Contact Information: \n";
        for(Object contact: contacts) {
    		string += "--> " + contact;
    	}
		string += "Role Information: \n";
        for(Object role: roles) {
    		string += "--> " + role;
    	}
    	return string;
	}

	@Override
	public int compareTo(Person person) {
		return Float.compare(gwa, person.getGwa());
	}
}
