package com.ty.Hospital.HospitalBoot_prc.repositery;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.Hospital.HospitalBoot_prc.dto.Encounter;

public interface EncounterRepository extends JpaRepository<Encounter, Integer> {

}
