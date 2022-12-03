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
import com.ty.Hospital.HospitalBoot_prc.dto.Encounter;
import com.ty.Hospital.HospitalBoot_prc.service.EncounterService;
import com.ty.Hospital.HospitalBoot_prc.util.ResponseStructure;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("encounter")
public class EncounterController {
	@Autowired
	private EncounterService EncounterService;

	@ApiOperation(value="Update Encounter", notes="It is used to update Encounter")
	@ApiResponses(value= {
			@ApiResponse(code=500,message="Internal Server Error"),
			@ApiResponse(code=404,message="NotFound")})
	
	@PutMapping(consumes= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, produces= {MediaType.APPLICATION_JSON_VALUE})
	
	public ResponseEntity<ResponseStructure<Encounter>> updateEncounter(@RequestBody Encounter encounter,@RequestParam int id) {
		return EncounterService.updateEncounter(encounter, id);
	}

	@ApiOperation(value="Get Encounter", notes="It is used to get Encounter")
	@ApiResponses(value= {
			@ApiResponse(code=500,message="Internal Server Error"),
			@ApiResponse(code=404,message="NotFound")})
	@GetMapping
	public ResponseEntity<ResponseStructure<Encounter>> findEncounter(@RequestParam int id)
	{
		return EncounterService.getEncounter(id);

	}
}
