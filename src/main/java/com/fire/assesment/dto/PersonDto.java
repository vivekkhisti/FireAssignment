package com.fire.assesment.dto;

import java.util.List;

import com.fire.assesment.entities.Person;

public class PersonDto {

	List<Person> person;

	public List<Person> getPerson() {
		return person;
	}

	public void setPerson(List<Person> person) {
		this.person = person;
	}
}
