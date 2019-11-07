package com.ecc.exercises.springexercise.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name="role")
public class Role extends BaseEntity {
	
	@Column(name="role", nullable=false)
	private String role;

	public Role() {

	}

	public Role(String role) {
		this.role=role;
	}

	public String getRole() {
		return this.role;
	} 

	public void setRole(String role) {
		this.role = role;
	}

	public boolean equals(Object obj) {
		if (obj == null) 
			return false;
		if (!this.getClass().equals(obj.getClass())) 
			return false;

		Role obj2 = (Role) obj;
		if((super.getId() == obj2.getId()) && (this.role.equals(obj2.getRole()))) {
			return true;
		}
		return false;
   	}
   
	public int hashCode() {
		int tmp = 0;
		tmp = (super.getId() + role).hashCode();
		return tmp;
  	}

  	public String toString() {
  		String string;
  		string = role;
  		return string;
  	}
}