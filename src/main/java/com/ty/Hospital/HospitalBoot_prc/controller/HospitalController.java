package com.ty.Hospital.HospitalBoot_prc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.Hospital.HospitalBoot_prc.dto.Hospital;
import com.ty.Hospital.HospitalBoot_prc.util.ResponseStructure;





@RestController
@RequestMapping("hospital")
public class HospitalController {
	@Autowired
	private HospitalService HospitalService;

	@ApiOperation(value="Save User", notes="It is used to save User")
	@ApiResponses(value= {
			@ApiResponse(code=201,message="created"),
			@ApiResponse(code=500,message="Internal Server Error"),
			@ApiResponse(code=404,message="NotFound")})
	
	@PostMapping(consumes= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, produces= {MediaType.APPLICATION_JSON_VALUE})
	
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(@RequestBody @Valid Hospital hospital) {
		return hospitalService.saveHospital(hospital);
	}

	@ApiOperation(value="Update Hospital", notes="It is used to update Hospital")
	@ApiResponses(value= {
			@ApiResponse(code=201,message="created"),
			@ApiResponse(code=500,message="Internal Server Error"),
			@ApiResponse(code=404,message="NotFound")})
	
	@PutMapping(consumes= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, produces= {MediaType.APPLICATION_JSON_VALUE})
	
	public ResponseEntity<ResponseStructure<Hospital>> updateUser(@RequestBody Hospital hospital,@RequestParam int id) {
		return hospitalService.updateHospital(hospital, id);
	}
	
	@ApiOperation(value="Delete Hospital", notes="It is used to delete Hospital")
	@ApiResponses(value= {
			@ApiResponse(code=201,message="created"),
			@ApiResponse(code=500,message="Internal Server Error"),
			@ApiResponse(code=404,message="NotFound")})
	@DeleteMapping
	public ResponseEntity<ResponseStructure<String>> deleteHospital(@RequestParam int id) {
		return hospitalService.deleteHospital(id);
	}

	@ApiOperation(value="Get User", notes="It is used to get User")
	@ApiResponses(value= {
			@ApiResponse(code=201,message="created"),
			@ApiResponse(code=500,message="Internal Server Error"),
			@ApiResponse(code=404,message="NotFound")})
	@GetMapping
	public ResponseEntity<ResponseStructure<Hospital>> findHospital(@RequestParam int id)
	{
		return hospitalService.findHospitalById(id);

	}
	
}
