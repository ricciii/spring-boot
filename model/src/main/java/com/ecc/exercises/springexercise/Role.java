package com.ecc.exercises.springexercise.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name="role")
public class Role extends BaseEntity {
	
	@NotBlank(message="Required")
	@Column(name="name", nullable=false)
	private String name;

	public Role() {

	}

	public String getName() {
		return this.name;
	} 

	public void setName(String name) {
		this.name = name;
	}

	public boolean equals(Object obj) {
		if (obj == null) 
			return false;
		if (!this.getClass().equals(obj.getClass())) {
			return false;
		}

		Role obj2 = (Role) obj;
		if((super.getId() == obj2.getId()) && (this.name.equals(obj2.getName()))) {
			return true;
		}
		return false;
   	}
   
	public int hashCode() {
		int tmp = 0;
		tmp = (super.getId() + this.name).hashCode();
		return tmp;
  	}

  	public String toString() {
  		return this.name;
  	}
}