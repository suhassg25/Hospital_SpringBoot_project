package com.ty.Hospital.HospitalBoot_prc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.Hospital.HospitalBoot_prc.dao.LocationDao;
import com.ty.Hospital.HospitalBoot_prc.dto.Location;
import com.ty.Hospital.HospitalBoot_prc.exception.NoSuchIdFoundException;
import com.ty.Hospital.HospitalBoot_prc.exception.UnableToUpdateException;
import com.ty.Hospital.HospitalBoot_prc.util.ResponseStructure;

@Service
public class LocationService {

	@Autowired
	private LocationDao dao;
	
	public ResponseEntity<ResponseStructure<Location>> updateLocation(Location location, int id)
	{
		Location Location2=dao.getLocationById(id);
		
		ResponseEntity<ResponseStructure<Location>> entity;
		ResponseStructure<Location> responseStructure=new ResponseStructure<>();
		if(Location2!=null) {
			location.setId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Updated Data");
			responseStructure.setData(dao.updateLocation(location));
			return entity=new ResponseEntity<ResponseStructure<Location>>(responseStructure,HttpStatus.OK);
		}
		throw new UnableToUpdateException();		
	}
	
	public ResponseEntity<ResponseStructure<Location>> getLocation( int id)
	{
		Location Location=dao.getLocationById(id);
		ResponseEntity<ResponseStructure<Location>> entity;
		ResponseStructure<Location> responseStructure=new ResponseStructure<>();
		if(Location!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Found Data");
			responseStructure.setData(dao.getLocationById(id));
			return entity=new ResponseEntity<ResponseStructure<Location>>(responseStructure,HttpStatus.OK);
		}
		throw new NoSuchIdFoundException();		
	}
	
}
