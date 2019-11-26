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
	
	@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
	@NotNull(message="Required")
	@ManyToOne(targetEntity=ContactType.class)
	@JoinColumn(name = "type_id")
	private ContactType type; 

	@NotNull
	@NotBlank(message="Required")
	@Column(name="info", nullable=false)
	private String info;

	public Contact() {
	
	}

	public ContactType getType() {
		return this.type;
	}

	public String getInfo() {
		return this.info;
	}

	public void setType(ContactType type) {
		this.type = type;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public boolean equals(Object obj) {
		if (obj == null) 
			return false;
		if (!this.getClass().equals(obj.getClass())) 
			return false;

		Contact obj2 = (Contact) obj;
		if((super.getId() == obj2.getId()) && (this.info.equals(obj2.getInfo()))) {
			return true;
		}
		return false;
   	}
   
	public int hashCode() {
		int tmp = 0;
		tmp = (super.getId() + info).hashCode();
		return tmp;
  	}

  	public String toString() {
  		String string;
  		string = type + ": " + info + "\n";
  		return string;
  	}
}