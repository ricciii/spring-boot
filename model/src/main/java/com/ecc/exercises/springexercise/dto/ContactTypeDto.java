package com.ecc.exercises.springexercise.model.dto;

public class ContactTypeDto extends BaseEntityDto {

	private String name;

	public String getName() {
   		return this.name;
   	}

   	public void setName(String name) {
   		this.name = name;
   	} 

  	public String toString() {
  		String string;
  		string = name;
  		return string;
  	}
}