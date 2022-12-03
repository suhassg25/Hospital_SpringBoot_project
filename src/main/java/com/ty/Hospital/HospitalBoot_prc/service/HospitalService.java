package com.ty.Hospital.HospitalBoot_prc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.Hospital.HospitalBoot_prc.dao.HospitalDao;
import com.ty.Hospital.HospitalBoot_prc.dto.Branch;
import com.ty.Hospital.HospitalBoot_prc.dto.Hospital;
import com.ty.Hospital.HospitalBoot_prc.dto.Location;
import com.ty.Hospital.HospitalBoot_prc.exception.NoSuchIdFoundException;
import com.ty.Hospital.HospitalBoot_prc.exception.UnableToUpdateException;
import com.ty.Hospital.HospitalBoot_prc.util.ResponseStructure;

@Service
public class HospitalService {

@Autowired
private HospitalDao dao;
	
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(Hospital hospital)
	{
		
		ResponseEntity<ResponseStructure<Hospital>> entity;
		ResponseStructure<Hospital> responseStructure=new ResponseStructure<Hospital>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Created Data");
		responseStructure.setData(dao.saveHospital(hospital)); 
		return entity=new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.CREATED);
		
	}
	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(Hospital hospital, int id)
	{
		Hospital hospital2=dao.getHospitalById(id);
		ResponseEntity<ResponseStructure<Hospital>> entity;
		ResponseStructure<Hospital> responseStructure=new ResponseStructure<Hospital>();
		if(hospital2!=null) {
			hospital.setId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Updated Data");
			responseStructure.setData(dao.updateHospital(hospital));
			return entity=new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.OK);
		}
		throw new UnableToUpdateException();		
	}
	public ResponseEntity<ResponseStructure<String>> deleteHospital( int id)
	{
		Hospital hospital2=dao.getHospitalById(id);
		ResponseEntity<ResponseStructure<String>> entity;
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		if(hospital2!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Deleted Data");
			responseStructure.setData(dao.deleteHospitalById(id));
			return entity=new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.OK);
		}
		throw new NoSuchIdFoundException();			
	}
	public ResponseEntity<ResponseStructure<Hospital>> getHospital( int id)
	{
		Hospital hospital2=dao.getHospitalById(id);
		ResponseEntity<ResponseStructure<Hospital>> entity;
		ResponseStructure<Hospital> responseStructure=new ResponseStructure<Hospital>();
		if(hospital2!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Found Data");
			responseStructure.setData(dao.getHospitalById(id));
			return entity=new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.OK);
		}
		throw new NoSuchIdFoundException();		
	}
	
	
}
