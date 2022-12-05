package com.ty.Hospital.HospitalBoot_prc.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
public class Hospital {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull( message = "Name must be entered")
	private String name;
	@NotNull(message = "Phone number not found")
	private long phone;
	@NotNull(message = "Enter email address")
	private String email;
	@OneToMany(cascade =  CascadeType.ALL)
	private List<Branch> branch;
	
	
	public List<Branch> getBranch() {
		return branch;
	}
	public void setBranch(List<Branch> branch) {
		this.branch = branch;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	

}
