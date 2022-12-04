package com.ty.Hospital.HospitalBoot_prc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.ty.Hospital.HospitalBoot_prc.dao.EncounterDao;
import com.ty.Hospital.HospitalBoot_prc.dao.PersonDao;
import com.ty.Hospital.HospitalBoot_prc.dto.Encounter;
import com.ty.Hospital.HospitalBoot_prc.dto.Person;
import com.ty.Hospital.HospitalBoot_prc.exception.NoSuchIdFoundException;
import com.ty.Hospital.HospitalBoot_prc.exception.UnableToUpdateException;
import com.ty.Hospital.HospitalBoot_prc.util.ResponseStructure;


@Service
public class EncounterService {

	@Autowired
	private EncounterDao dao;

	@Autowired
	PersonDao dao2;

	public ResponseEntity<ResponseStructure<Encounter>> updateEncounter(Encounter Encounter, int id) {
		Encounter Encounter2 = dao.getEncounterById(id);

		ResponseEntity<ResponseStructure<Encounter>> entity;
		ResponseStructure<Encounter> responseStructure = new ResponseStructure<>();
		if (Encounter2 != null) {
			Encounter.setId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Updated Data");
			responseStructure.setData(dao.updateEncounter(Encounter));
		} else {
			throw new UnableToUpdateException();
		}
		return entity = new ResponseEntity<ResponseStructure<Encounter>>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Encounter>> getEncounter(int id) {
		Encounter Encounter = dao.getEncounterById(id);
		ResponseEntity<ResponseStructure<Encounter>> entity;
		ResponseStructure<Encounter> responseStructure = new ResponseStructure<>();
		if (Encounter != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Found Data");
			responseStructure.setData(dao.getEncounterById(id));
		} else {
			throw new NoSuchIdFoundException();
		}
		return entity = new ResponseEntity<ResponseStructure<Encounter>>(responseStructure, HttpStatus.OK);
	}

/*	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(Encounter encounter, int id) {
	
		Person p1 = dao2.getPersonById(id);
		ResponseEntity<ResponseStructure<Encounter>> entity;
		List<Encounter> list = new ArrayList<Encounter>();
		ResponseStructure<Encounter> responseStructure = new ResponseStructure<Encounter>();
		if (p1 != null) {
			
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setMessage("Saved");
			list.add(encounter);
			p1.setEncounter(list);
			responseStructure.setData(dao.saveEncounter(encounter));
			Encounter encounter2=new Encounter();
		encounter2.setId(encounter.getId());

		} else {
			throw new NoSuchIdFoundException();
		}
		
		return entity = new ResponseEntity<ResponseStructure<Encounter>>(responseStructure, HttpStatus.CREATED);
	}*/
}
