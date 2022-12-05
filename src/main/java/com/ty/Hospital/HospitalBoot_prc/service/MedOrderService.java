package com.ty.Hospital.HospitalBoot_prc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.ty.Hospital.HospitalBoot_prc.dao.EncounterDao;
import com.ty.Hospital.HospitalBoot_prc.dao.MedOrderDao;
import com.ty.Hospital.HospitalBoot_prc.dto.Encounter;
import com.ty.Hospital.HospitalBoot_prc.dto.MedOrder;
import com.ty.Hospital.HospitalBoot_prc.dto.Person;
import com.ty.Hospital.HospitalBoot_prc.dto.MedOrder;
import com.ty.Hospital.HospitalBoot_prc.exception.NoSuchIdFoundException;
import com.ty.Hospital.HospitalBoot_prc.exception.UnableToUpdateException;
import com.ty.Hospital.HospitalBoot_prc.util.ResponseStructure;

@Service
public class MedOrderService {

	@Autowired
	private MedOrderDao dao;
	
	@Autowired
	EncounterDao dao2;
	
	public ResponseEntity<ResponseStructure<MedOrder>> updateMedOrder(MedOrder medOrder, int id)
	{
		MedOrder MedOrder2=dao.getMedOrderById(id);
		
		ResponseEntity<ResponseStructure<MedOrder>> entity;
		ResponseStructure<MedOrder> responseStructure=new ResponseStructure<>();
		if(MedOrder2!=null) {
			medOrder.setId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Updated Data");
			responseStructure.setData(dao.updateMedOrder(medOrder));
		}
		else {
			throw new UnableToUpdateException();		
		}
		return entity=new ResponseEntity<ResponseStructure<MedOrder>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<MedOrder>> getMedOrder( int id)
	{
		MedOrder MedOrder=dao.getMedOrderById(id);
		ResponseEntity<ResponseStructure<MedOrder>> entity;
		ResponseStructure<MedOrder> responseStructure=new ResponseStructure<>();
		if(MedOrder!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Found Data");
			responseStructure.setData(dao.getMedOrderById(id));
		}
		else {
			throw new NoSuchIdFoundException();		
		}
		return entity=new ResponseEntity<ResponseStructure<MedOrder>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<MedOrder>> saveMedorder(@RequestBody MedOrder medOrder, @RequestParam int id)
	{
		
		Encounter p1=dao2.getEncounterById(id);
		
		ResponseEntity<ResponseStructure<MedOrder>> entity;
		List<MedOrder> list=p1.getMedOrder();
		ResponseStructure<MedOrder> responseStructure=new ResponseStructure();
		if(p1!=null)
		{
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setMessage("Saved");
			 responseStructure.setData(dao.saveMedOrder(medOrder));
			 list.add(medOrder);
			 p1.setMedOrder(list);
			 dao2.updateEncounter(p1);
		}
		else
		{
			throw new NoSuchIdFoundException();
		}
		return entity= new ResponseEntity<ResponseStructure<MedOrder>>(responseStructure,HttpStatus.CREATED); 
	}
}
