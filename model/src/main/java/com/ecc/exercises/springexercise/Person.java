package com.ecc.exercises.springexercise.model;

import java.time.LocalDate;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.Valid;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name="person")
public class Person extends BaseEntity implements Comparable<Person> {
	
	@Valid
	@Embedded
	private Name name;
	
	@Valid
	@Embedded
	private Address address;
	
	@NotNull(message="Required")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="date_of_birth", nullable=false)
	private LocalDate dateOfBirth;
	
	@NotNull(message="Required")
	@Column(name="gwa", nullable=false)
	private float gwa;
	
	@NotNull(message="Required")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="date_hired", nullable=false)
	private LocalDate dateHired;
	
	@NotNull(message="Required")
	@Column(name="currently_employed", nullable=false)
	private Boolean currentlyEmployed;
	
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@OneToMany(fetch=FetchType.EAGER, cascade = { CascadeType.ALL }, targetEntity=Contact.class, orphanRemoval=true)
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name="person_id")
	@BatchSize(size=5)
	private Set contacts;
	
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@ManyToMany(fetch=FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, targetEntity=Role.class)
	@Fetch(FetchMode.JOIN)
	@BatchSize(size=5)
	@JoinTable(name = "person_role", joinColumns = { @JoinColumn(name = "person_id") }, 
		inverseJoinColumns = { @JoinColumn(name = "role_id") })
	private Set roles;

	public Person() {

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

	@Override
	public int compareTo(Person person) {
		return Float.compare(gwa, person.getGwa());
	}
}
