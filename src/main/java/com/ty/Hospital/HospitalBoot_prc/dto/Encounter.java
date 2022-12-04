package com.ty.Hospital.HospitalBoot_prc.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Encounter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message = "Enter reason for encounter")
	private String reason;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<MedOrder>medOrder;
	
	@OneToMany
	private List<Branch> branches;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public List<MedOrder> getMedOrder() {
		return medOrder;
	}
	public void setMedOrder(List<MedOrder> medOrder) {
		this.medOrder = medOrder;
	}
	

}
