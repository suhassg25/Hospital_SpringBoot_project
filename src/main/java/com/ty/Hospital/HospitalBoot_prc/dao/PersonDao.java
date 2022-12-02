package com.ty.Hospital.HospitalBoot_prc.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.Hospital.HospitalBoot_prc.dto.Person;
import com.ty.Hospital.HospitalBoot_prc.repositery.PersonRepository;

@Repository
public class PersonDao {

	@Autowired
	PersonRepository personRepository;

	public Person savePerson(Person person) {
		return personRepository.save(person);
	}

	public Person updatePerson(Person person) {
		return personRepository.save(person);
	}

	public Person getPersonById(int id) {
		Optional<Person> optional = personRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		}
		return optional.get();
	}

	public String deletePersonById(int id) {
		personRepository.deleteById(id);
		return "deleted";
	}
}
