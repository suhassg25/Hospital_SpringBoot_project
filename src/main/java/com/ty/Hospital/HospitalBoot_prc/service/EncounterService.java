package com.ty.Hospital.HospitalBoot_prc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.Hospital.HospitalBoot_prc.dao.EncounterDao;
import com.ty.Hospital.HospitalBoot_prc.dto.Encounter;
import com.ty.Hospital.HospitalBoot_prc.exception.NoSuchIdFoundException;
import com.ty.Hospital.HospitalBoot_prc.exception.UnableToUpdateException;
import com.ty.Hospital.HospitalBoot_prc.util.ResponseStructure;

@Service
public class EncounterService {

	@Autowired
	private EncounterDao dao;
	public ResponseEntity<ResponseStructure<Encounter>> updateEncounter(Encounter Encounter, int id)
	{
		Encounter Encounter2=dao.getEncounterById(id);
		
		ResponseEntity<ResponseStructure<Encounter>> entity;
		ResponseStructure<Encounter> responseStructure=new ResponseStructure<>();
		if(Encounter2!=null) {
			Encounter.setId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Updated Data");
			responseStructure.setData(dao.updateEncounter(Encounter));
			return entity=new ResponseEntity<ResponseStructure<Encounter>>(responseStructure,HttpStatus.OK);
		}
		throw new UnableToUpdateException();		
	}
	
	public ResponseEntity<ResponseStructure<Encounter>> getEncounter( int id)
	{
		Encounter Encounter=dao.getEncounterById(id);
		ResponseEntity<ResponseStructure<Encounter>> entity;
		ResponseStructure<Encounter> responseStructure=new ResponseStructure<>();
		if(Encounter!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Found Data");
			responseStructure.setData(dao.getEncounterById(id));
			return entity=new ResponseEntity<ResponseStructure<Encounter>>(responseStructure,HttpStatus.OK);
		}
		throw new NoSuchIdFoundException();		
	}
}
