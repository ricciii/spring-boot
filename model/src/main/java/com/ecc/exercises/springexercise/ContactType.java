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
import javax.persistence.Table;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Table(name="contact_type")
public class ContactType extends BaseEntity {
	
	@Column(name="name", nullable=false)
	private String name;

	public boolean equals(Object obj) {
		if (obj == null) 
			return false;
		if (!this.getClass().equals(obj.getClass())) 
			return false;

		ContactType obj2 = (ContactType) obj;
		if((super.getId() == obj2.getId()) && (this.name.equals(obj2.getName()))) {
			return true;
		}
		return false;
   	}

   	public String getName() {
   		return this.name;
   	}

   	public void setName(String name) {
   		this.name = name;
   	}
   
	public int hashCode() {
		int tmp = 0;
		tmp = (super.getId() + name).hashCode();
		return tmp;
  	}

  	public String toString() {
  		String string;
  		string = name;
  		return string;
  	}
}