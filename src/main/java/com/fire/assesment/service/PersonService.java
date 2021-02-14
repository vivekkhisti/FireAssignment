package com.fire.assesment.service;

import com.fire.assesment.dto.PersonDto;

public interface PersonService {
	
	PersonDto addPerson(PersonDto personDto) throws Exception;
	
	PersonDto updatePerson(PersonDto personDto) throws Exception;
	
	PersonDto getPersons() throws Exception;
	
	boolean deletePerson(long id) throws Exception;

}
