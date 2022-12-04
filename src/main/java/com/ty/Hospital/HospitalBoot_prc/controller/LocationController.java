package com.ty.Hospital.HospitalBoot_prc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.Hospital.HospitalBoot_prc.dto.Location;
import com.ty.Hospital.HospitalBoot_prc.service.LocationService;
import com.ty.Hospital.HospitalBoot_prc.util.ResponseStructure;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@RestController
@RequestMapping("location")
public class LocationController {
	@Autowired
	private LocationService locationService;

	@ApiOperation(value="Update Location", notes="It is used to update Location")
	@ApiResponses(value= {
		@ApiResponse(code=500,message="Internal Server Error"),
			@ApiResponse(code=404,message="NotFound")})
	
	@PutMapping(consumes= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, produces= {MediaType.APPLICATION_JSON_VALUE})
	
	public ResponseEntity<ResponseStructure<Location>> updateLocation(@RequestBody Location location,@RequestParam int id) {
		return locationService.updateLocation(location, id);
	}

	@ApiOperation(value="Get Location", notes="It is used to get Location")
	@ApiResponses(value= {
			@ApiResponse(code=500,message="Internal Server Error"),
			@ApiResponse(code=404,message="NotFound")})
	@GetMapping
	public ResponseEntity<ResponseStructure<Location>> findLocation(@RequestParam int id)
	{
		return locationService.getLocation(id);

	}
}
