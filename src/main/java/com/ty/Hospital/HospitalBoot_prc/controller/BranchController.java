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

import com.ty.Hospital.HospitalBoot_prc.dto.Branch;
import com.ty.Hospital.HospitalBoot_prc.service.BranchService;
import com.ty.Hospital.HospitalBoot_prc.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("branch")
public class BranchController {
	
		@Autowired
		private BranchService branchService;

		

		@ApiOperation(value="Update Branch", notes="It is used to update Branch")
		@ApiResponses(value= {
				@ApiResponse(code=201,message="created"),
				@ApiResponse(code=500,message="Internal Server Error"),
				@ApiResponse(code=404,message="NotFound")})
		
		@PutMapping(consumes= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, produces= {MediaType.APPLICATION_JSON_VALUE})
		
		public ResponseEntity<ResponseStructure<Branch>> updateUser(@RequestBody Branch branch,@RequestParam int id) {
			return branchService.updateBranch(branch, id);
		}
		
		

		@ApiOperation(value="Get Branch", notes="It is used to get Branch")
		@ApiResponses(value= {
				@ApiResponse(code=201,message="created"),
				@ApiResponse(code=500,message="Internal Server Error"),
				@ApiResponse(code=404,message="NotFound")})
		@GetMapping
		public ResponseEntity<ResponseStructure<Branch>> findBranch(@RequestParam int id)
		{
			return branchService.getBranch(id);

		}
}
