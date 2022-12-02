package com.ty.Hospital.HospitalBoot_prc.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.Hospital.HospitalBoot_prc.dto.Branch;
import com.ty.Hospital.HospitalBoot_prc.repositery.BranchRepository;

@Repository
public class BranchDao {

	@Autowired
	BranchRepository branchRepository;

	public Branch saveBranch(Branch branch) {
		return branchRepository.save(branch);
	}

	public Branch updateBranch(Branch branch) {
		return branchRepository.save(branch);
	}

	public Branch getBranchById(int id) {
		Optional<Branch> optional = branchRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		}
		return optional.get();
	}

	public String deleteBranchById(int id) {
		branchRepository.deleteById(id);
		return "deleted";
	}
}
