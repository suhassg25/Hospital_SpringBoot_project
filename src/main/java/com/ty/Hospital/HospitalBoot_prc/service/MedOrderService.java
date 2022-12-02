package com.ty.Hospital.HospitalBoot_prc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.Hospital.HospitalBoot_prc.dao.MedOrderDao;
import com.ty.Hospital.HospitalBoot_prc.dto.MedOrder;
import com.ty.Hospital.HospitalBoot_prc.dto.MedOrder;
import com.ty.Hospital.HospitalBoot_prc.exception.NoSuchIdFoundException;
import com.ty.Hospital.HospitalBoot_prc.exception.UnableToUpdateException;
import com.ty.Hospital.HospitalBoot_prc.util.ResponseStructure;

@Service
public class MedOrderService {

	@Autowired
	private MedOrderDao dao;
	
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
			return entity=new ResponseEntity<ResponseStructure<MedOrder>>(responseStructure,HttpStatus.OK);
		}
		throw new UnableToUpdateException();		
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
			return entity=new ResponseEntity<ResponseStructure<MedOrder>>(responseStructure,HttpStatus.OK);
		}
		throw new NoSuchIdFoundException();		
	}
}
