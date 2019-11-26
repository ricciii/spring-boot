package com.ecc.exercises.springexercise.model.dto;

import javax.validation.constraints.NotBlank;

public class RoleDto extends BaseEntityDto {
	
	@NotBlank(message="Required")
	private String name;

	public RoleDto() {

	}

	public RoleDto(String name) {
		this.name=name;
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

		RoleDto obj2 = (RoleDto) obj;
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