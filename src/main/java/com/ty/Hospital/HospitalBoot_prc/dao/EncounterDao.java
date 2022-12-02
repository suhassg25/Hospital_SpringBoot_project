package com.ty.Hospital.HospitalBoot_prc.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.Hospital.HospitalBoot_prc.dto.Encounter;
import com.ty.Hospital.HospitalBoot_prc.repositery.EncounterRepository;

@Repository
public class EncounterDao {

	@Autowired
	EncounterRepository encounterRepository;

	public Encounter saveEncounter(Encounter encounter) {
		return encounterRepository.save(encounter);
	}

	public Encounter updateEncounter(Encounter encounter) {
		return encounterRepository.save(encounter);
	}

	public Encounter getEncounterById(int id) {
		Optional<Encounter> optional = encounterRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		}
		return optional.get();
	}
}
