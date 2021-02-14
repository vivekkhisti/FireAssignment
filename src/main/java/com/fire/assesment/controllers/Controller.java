package com.fire.assesment.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fire.assesment.dto.PersonDto;
import com.fire.assesment.service.PersonService;

@RestController
public class Controller {
	
	@Autowired
	PersonService service;

	private static final Logger logger = LoggerFactory.getLogger(Controller.class);
	
	@RequestMapping(value = "/addPerson", method = RequestMethod.POST)
	PersonDto addPerson(@RequestBody PersonDto personDto) throws Exception {
		return service.addPerson(personDto);
	}
	
	@RequestMapping(value = "/updatePerson", method = RequestMethod.PUT)
	PersonDto updatePerson( @RequestBody PersonDto personDto) throws Exception {
		return service.updatePerson(personDto);
	}
	
	@RequestMapping(value = "/getPersons", method = RequestMethod.GET)
	PersonDto getPersons() throws Exception {
		return service.getPersons();
	}
	
	@RequestMapping(value = "/deletePerson", method = RequestMethod.DELETE)
	boolean deletePerson(@RequestParam long id) throws Exception {
		return service.deletePerson(id);
	}
	
}
