package com.ecc.exercises.springexercise.model;

import java.util.ArrayList;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name="contact")
public class Contact extends BaseEntity {
	
	@NotNull
	@NotBlank(message="Required")
	@Column(name="contact", nullable=false)
	private String contact;
	
	@NotNull(message="Required")
	@ManyToOne(targetEntity=ContactType.class)
	@JoinColumn(name = "type_id")
	private ContactType type; 

	public Contact() {
	
	}

	public Contact(ContactType type, String contact) {
		this.type = type;
		this.contact = contact;
	}

	public ContactType getType() {
		return this.type;
	}

	public String getContact() {
		return this.contact;
	}

	public void setType(ContactType type) {
		this.type = type;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public boolean equals(Object obj) {
		if (obj == null) 
			return false;
		if (!this.getClass().equals(obj.getClass())) 
			return false;

		Contact obj2 = (Contact) obj;
		if((super.getId() == obj2.getId()) && (this.contact.equals(obj2.getContact()))) {
			return true;
		}
		return false;
   	}
   
	public int hashCode() {
		int tmp = 0;
		tmp = (super.getId() + contact).hashCode();
		return tmp;
  	}

  	public String toString() {
  		String string;
  		string = type + ": " + contact + "\n";
  		return string;
  	}
}