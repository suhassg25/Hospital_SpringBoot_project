package com.ty.Hospital.HospitalBoot_prc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.Hospital.HospitalBoot_prc.dao.PersonDao;
import com.ty.Hospital.HospitalBoot_prc.dto.Branch;
import com.ty.Hospital.HospitalBoot_prc.dto.Encounter;
import com.ty.Hospital.HospitalBoot_prc.dto.Items;
import com.ty.Hospital.HospitalBoot_prc.dto.MedOrder;
import com.ty.Hospital.HospitalBoot_prc.dto.Person;
import com.ty.Hospital.HospitalBoot_prc.exception.NoSuchIdFoundException;
import com.ty.Hospital.HospitalBoot_prc.exception.UnableToUpdateException;
import com.ty.Hospital.HospitalBoot_prc.util.ResponseStructure;

@Service
public class PersonService {

	@Autowired
	private PersonDao dao;

	public ResponseEntity<ResponseStructure<Person>> savePerson(Person person) {
		double totalcost = 0;
		Person p1 = person;
		List<Encounter> list = p1.getEncounter();
		for (Encounter e : list) {
			List<MedOrder> medOrder = e.getMedOrder();

			for (MedOrder medOrder2 : medOrder) {
				MedOrder medOrder4 = new MedOrder();
				List<Items> items = medOrder2.getItems();

				for (Items items2 : items) {
					totalcost = totalcost + (items2.getPrice() * items2.getQuantity());
				}
				medOrder4.setTotalcost(totalcost);
			}

		}
		ResponseEntity<ResponseStructure<Person>> entity;
		ResponseStructure<Person> responseStructure = new ResponseStructure<Person>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Created Data");
		responseStructure.setData(dao.savePerson(person));
		return entity = new ResponseEntity<ResponseStructure<Person>>(responseStructure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<Person>> updatePerson(Person person, int id) {
		Person Person2 = dao.getPersonById(id);
		ResponseEntity<ResponseStructure<Person>> entity;
		ResponseStructure<Person> responseStructure = new ResponseStructure<Person>();
		if (Person2 != null) {
			person.setId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Updated Data");
			responseStructure.setData(dao.updatePerson(person));
			return entity = new ResponseEntity<ResponseStructure<Person>>(responseStructure, HttpStatus.OK);
		}
		throw new UnableToUpdateException();
	}

	public ResponseEntity<ResponseStructure<String>> deletePerson(int id) {
		Person Person2 = dao.getPersonById(id);
		ResponseEntity<ResponseStructure<String>> entity;
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		if (Person2 != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Deleted Data");
			responseStructure.setData(dao.deletePersonById(id));
			return entity = new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.OK);
		}
		throw new NoSuchIdFoundException();
	}

	public ResponseEntity<ResponseStructure<Person>> getPerson(int id) {
		Person Person2 = dao.getPersonById(id);
		ResponseEntity<ResponseStructure<Person>> entity;
		ResponseStructure<Person> responseStructure = new ResponseStructure<Person>();
		if (Person2 != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Found Data");
			responseStructure.setData(dao.getPersonById(id));
			return entity = new ResponseEntity<ResponseStructure<Person>>(responseStructure, HttpStatus.OK);
		}
		throw new NoSuchIdFoundException();
	}

}
