package com.ty.Hospital.HospitalBoot_prc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.Hospital.HospitalBoot_prc.dao.ItemsDao;
import com.ty.Hospital.HospitalBoot_prc.dto.Items;
import com.ty.Hospital.HospitalBoot_prc.exception.NoSuchIdFoundException;
import com.ty.Hospital.HospitalBoot_prc.exception.UnableToUpdateException;
import com.ty.Hospital.HospitalBoot_prc.util.ResponseStructure;

@Service
public class ItemsService {
	
	@Autowired
	private ItemsDao dao;

	public ResponseEntity<ResponseStructure<Items>> getItems(int id)
	{
		ResponseEntity<ResponseStructure<Items>> entity;
		ResponseStructure<Items> responseStructure=new ResponseStructure<Items>();
		
		Items items=dao.getItemsById(id);
		
		if(items!=null)
		{
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Found");
			responseStructure.setData(dao.getItemsById(id));
			return entity=new ResponseEntity<ResponseStructure<Items>>(responseStructure, HttpStatus.OK);
		}
		
		throw new NoSuchIdFoundException();
		
	}
	public ResponseEntity<ResponseStructure<Items>> upadateItems(Items items, int id)
	{
		ResponseEntity<ResponseStructure<Items>> entity;
		ResponseStructure<Items> responseStructure=new ResponseStructure<Items>();
		
		Items items2=dao.getItemsById(id);
		
		if(items2!=null)
		{
			items.setId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Updated");
			responseStructure.setData(dao.updateItems(items));
			return entity=new ResponseEntity<ResponseStructure<Items>>(responseStructure, HttpStatus.OK);
		}
		throw new UnableToUpdateException();
	}
	
}
