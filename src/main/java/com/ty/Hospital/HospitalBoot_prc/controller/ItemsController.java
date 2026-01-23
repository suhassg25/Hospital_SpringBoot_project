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

import com.ty.Hospital.HospitalBoot_prc.dto.Items;
import com.ty.Hospital.HospitalBoot_prc.dto.MedOrder;
import com.ty.Hospital.HospitalBoot_prc.service.ItemsService;
import com.ty.Hospital.HospitalBoot_prc.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("items")
public class ItemsController {
	@Autowired
	private ItemsService itemsService;

	@ApiOperation(value="Update Items", notes="It is used to update Items")
	@ApiResponses(value= {
			@ApiResponse(code=500,message="Internal Server Error"),
			@ApiResponse(code=404,message="NotFound")})
	
	@PutMapping(consumes= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, produces= {MediaType.APPLICATION_JSON_VALUE})
	
	public ResponseEntity<ResponseStructure<Items>> updateItems(@RequestBody Items items,@RequestParam int id) {
		return itemsService.upadateItems(items, id);
	}

	@ApiOperation(value="Get Items", notes="It is used to get Items")
	@ApiResponses(value= {
			@ApiResponse(code=500,message="Internal Server Error"),
			@ApiResponse(code=404,message="NotFound")})
	@GetMapping
	public ResponseEntity<ResponseStructure<Items>> findItems(@RequestParam int id)
	{
		return itemsService.getItems(id);

	}
	@ApiOperation(value = "Save Items", notes = "used to save Items")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "NotFound") })
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Items>> saveItems(@RequestBody Items items,
			@RequestParam int id) {
		return itemsService.saveItems(items, id);
	}
}
