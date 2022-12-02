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
import com.ty.Hospital.HospitalBoot_prc.dto.MedOrder;
import com.ty.Hospital.HospitalBoot_prc.service.MedOrderService;
import com.ty.Hospital.HospitalBoot_prc.util.ResponseStructure;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("medorder")
public class MedOrderController {
	@Autowired
	private MedOrderService medOrderService;

	@ApiOperation(value="Update MedOrder", notes="It is used to update MedOrder")
	@ApiResponses(value= {
			@ApiResponse(code=201,message="created"),
			@ApiResponse(code=500,message="Internal Server Error"),
			@ApiResponse(code=404,message="NotFound")})
	
	@PutMapping(consumes= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, produces= {MediaType.APPLICATION_JSON_VALUE})
	
	public ResponseEntity<ResponseStructure<MedOrder>> updateMedOrder(@RequestBody MedOrder medOrder,@RequestParam int id) {
		return medOrderService.updateMedOrder(medOrder, id);
	}

	@ApiOperation(value="Get MedOrder", notes="It is used to get MedOrder")
	@ApiResponses(value= {
			@ApiResponse(code=201,message="created"),
			@ApiResponse(code=500,message="Internal Server Error"),
			@ApiResponse(code=404,message="NotFound")})
	@GetMapping
	public ResponseEntity<ResponseStructure<MedOrder>> findMedOrder(@RequestParam int id)
	{
		return medOrderService.getMedOrder(id);

	}
}
