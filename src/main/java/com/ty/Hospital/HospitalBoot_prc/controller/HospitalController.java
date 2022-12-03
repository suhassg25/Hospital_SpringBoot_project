package com.ty.Hospital.HospitalBoot_prc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.Hospital.HospitalBoot_prc.dto.Hospital;
import com.ty.Hospital.HospitalBoot_prc.service.HospitalService;
import com.ty.Hospital.HospitalBoot_prc.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("hospotal")
public class HospitalController {

	@Autowired
	private HospitalService hospitalService;

	@ApiOperation(value = "save Hospital", notes = "It is used to save the Hospital details along with branches and location")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Internal server Error") })
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(@RequestBody Hospital hospital) {
		return hospitalService.saveHospital(hospital);
	}
	
	@ApiOperation(value = "updates Hospitals", notes = "It is used to update the Hospital")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Internal server Error") })
@PutMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
		MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(@RequestBody Hospital hospital, @RequestParam int id)
	{
		return hospitalService.updateHospital(hospital, id);
	}
	
	@ApiOperation(value = "fetch Hospital", notes = "It is used to Fetch the Hospital")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Internal server Error") })
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Hospital>> getHospital(@RequestParam int id)
	{
		return hospitalService.getHospital(id);
	}
	
}
