package com.ty.Hospital.HospitalBoot_prc.controller;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.Hospital.HospitalBoot_prc.dto.Person;
import com.ty.Hospital.HospitalBoot_prc.service.PersonService;
import com.ty.Hospital.HospitalBoot_prc.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@RestController
@RequestMapping("Person")
public class PersonController {
	
		@Autowired
		private PersonService personService;

		@ApiOperation(value="Save Person", notes="It is used to save Person")
		@ApiResponses(value= {
				@ApiResponse(code=201,message="created"),
				@ApiResponse(code=500,message="Internal Server Error"),
				@ApiResponse(code=404,message="NotFound")})
		
		@PostMapping(consumes= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, produces= {MediaType.APPLICATION_JSON_VALUE})
		
		public ResponseEntity<ResponseStructure<Person>> savePerson(@RequestBody @Valid Person person) {
			return personService.savePerson(person);
		}

		@ApiOperation(value="Update Person", notes="It is used to update Person")
		@ApiResponses(value= {
				@ApiResponse(code=500,message="Internal Server Error"),
				@ApiResponse(code=404,message="NotFound")})
		
		@PutMapping(consumes= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, produces= {MediaType.APPLICATION_JSON_VALUE})
		
		public ResponseEntity<ResponseStructure<Person>> updatePerson(@RequestBody Person person,@RequestParam int id) {
			return personService.updatePerson(person, id);
		}
		
		@ApiOperation(value="Delete Person", notes="It is used to delete Person")
		@ApiResponses(value= {
				@ApiResponse(code=500,message="Internal Server Error"),
				@ApiResponse(code=404,message="NotFound")})
		@DeleteMapping
		public ResponseEntity<ResponseStructure<String>> deletePerson(@RequestParam int id) {
			return personService.deletePerson(id);
		}

		@ApiOperation(value="Get Person", notes="It is used to get  Person")
		@ApiResponses(value= {
				@ApiResponse(code=500,message="Internal Server Error"),
				@ApiResponse(code=404,message="NotFound")})
		@GetMapping
		public ResponseEntity<ResponseStructure<Person>> findPerson(@RequestParam int id)
		{
			return personService.getPerson(id);

		}
}
