package com.ty.Hospital.HospitalBoot_prc.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.Hospital.HospitalBoot_prc.dto.Hospital;
import com.ty.Hospital.HospitalBoot_prc.repositery.HospitalRepositery;

@Repository
public class HospitalDao {

	@Autowired
	HospitalRepositery hospitalRepositery;

	public Hospital saveHospital(Hospital hospital) {
		return hospitalRepositery.save(hospital);
	}

	public Hospital updateHospital(Hospital hospital) {
		return hospitalRepositery.save(hospital);
	}

	public Hospital getHospitalById(int id) {
		Optional<Hospital> optional = hospitalRepositery.findById(id);
		if (optional.isEmpty()) {
			return null;
		}
		return optional.get();
	}

	public String deleteHospitalById(int id) {
		hospitalRepositery.deleteById(id);
		return "deleted";
	}
}
