package com.fire.assesment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fire.assesment.entities.Person;

public interface PersonRepo extends JpaRepository<Person, Long> {
	

}
