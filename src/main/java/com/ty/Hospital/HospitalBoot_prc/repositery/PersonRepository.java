package com.ty.Hospital.HospitalBoot_prc.repositery;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.Hospital.HospitalBoot_prc.dto.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
