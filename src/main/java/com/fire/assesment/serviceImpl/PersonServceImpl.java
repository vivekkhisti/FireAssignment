package com.fire.assesment.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fire.assesment.dto.PersonDto;
import com.fire.assesment.entities.Person;
import com.fire.assesment.repositories.PersonRepo;
import com.fire.assesment.service.PersonService;

@Service
public class PersonServceImpl implements PersonService {

	@Autowired
	PersonRepo personRepo;

	@Override
	public PersonDto addPerson(PersonDto personDto) throws Exception {
		// TODO Auto-generated method stub
		List<Person> persons = null;

		if (null != personDto && null != personDto.getPerson()) {
			persons = personDto.getPerson();
		}
		if (null != persons && persons.size() > 0) {
			persons = personRepo.saveAll(persons);
			personRepo.flush();
			PersonDto response = new PersonDto();
			response.setPerson(persons);
			return response;
		} else {
			throw new Exception("No data found to insert");
		}

	}

	@Override
	public PersonDto updatePerson(PersonDto personDto) throws Exception {
		// TODO Auto-generated method stub
		List<Person> persons = null;
		if (null != personDto && null != personDto.getPerson()) {
			persons = personDto.getPerson();
		}
		if (null != persons && persons.size() > 0) {
			PersonDto response = new PersonDto();
			List<Person> personList = new ArrayList<>();
			for (Person person : persons) {
				Optional<Person> personObject = personRepo.findById(person.getId());
				if (personObject.isPresent()) {
					Person object = personObject.get();
					object.setFirst_name(person.getFirst_name());
					object.setLast_name(person.getLast_name());
					object.setAge(person.getAge());
					object.setFavourite_colour(person.getFavourite_colour());
					object = personRepo.saveAndFlush(object);
					personList.add(object);
				}
			}
			response.setPerson(personList);
			return response;
		} else {
			throw new Exception("No data found to update");
		}

	}

	@Override
	public PersonDto getPersons() throws Exception {
		// TODO Auto-generated method stub
		PersonDto response = new PersonDto();
		List<Person> personList = personRepo.findAll();
		if(null != personList && personList.size() > 0) {
			response.setPerson(personList);
			return response;
		} else 
			throw new Exception("No data found for person");
	}

	@Override
	public boolean deletePerson(long id) throws Exception {
		// TODO Auto-generated method stub
		Optional<Person> personObject = personRepo.findById(id);
		if(personObject.isPresent()) {
			personRepo.deleteById(id);
			return true;
		} else {
			throw new Exception("Person with Id "+id+" does not exist");
		}
	}

}
