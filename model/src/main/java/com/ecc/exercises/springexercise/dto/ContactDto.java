package com.ecc.exercises.springexercise.model.dto;

import com.ecc.exercises.springexercise.model.dto.ContactTypeDto;

public class ContactDto extends BaseEntityDto {

	private ContactTypeDto type; 
	private String info;

	public ContactDto() {
	
	}

	public ContactTypeDto getType() {
		return this.type;
	}

	public String getInfo() {
		return this.info;
	}

	public void setType(ContactTypeDto type) {
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

		ContactDto obj2 = (ContactDto) obj;
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