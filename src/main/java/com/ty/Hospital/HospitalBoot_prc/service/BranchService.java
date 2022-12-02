package com.ty.Hospital.HospitalBoot_prc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.Hospital.HospitalBoot_prc.dao.BranchDao;
import com.ty.Hospital.HospitalBoot_prc.dto.Branch;
import com.ty.Hospital.HospitalBoot_prc.dto.Hospital;
import com.ty.Hospital.HospitalBoot_prc.exception.NoSuchIdFoundException;
import com.ty.Hospital.HospitalBoot_prc.exception.UnableToUpdateException;
import com.ty.Hospital.HospitalBoot_prc.util.ResponseStructure;

@Service
public class BranchService {

	@Autowired
	private BranchDao dao;

	public ResponseEntity<ResponseStructure<Branch>> updateBranch(Branch branch, int id)
	{
		Branch branch2=dao.getBranchById(id);
		
		ResponseEntity<ResponseStructure<Branch>> entity;
		ResponseStructure<Branch> responseStructure=new ResponseStructure<>();
		if(branch2!=null) {
			branch.setId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Updated Data");
			responseStructure.setData(dao.updateBranch(branch));
			return entity=new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);
		}
		throw new UnableToUpdateException();		
	}
	
	public ResponseEntity<ResponseStructure<Branch>> getBranch( int id)
	{
		Branch branch=dao.getBranchById(id);
		ResponseEntity<ResponseStructure<Branch>> entity;
		ResponseStructure<Branch> responseStructure=new ResponseStructure<>();
		if(branch!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Found Data");
			responseStructure.setData(dao.getBranchById(id));
			return entity=new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);
		}
		throw new NoSuchIdFoundException();		
	}
	
}
