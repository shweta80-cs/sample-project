package com.example.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="applicants")
public class TableToImportInExcel {
	
	@Id
	@Column(name="id")
	private Integer ApplicantId;
	
	@Column(name="applicanttype")
	private Integer Applicanttypeid;
	
	@Column(name="city")
	private String City;
	
	@Column(name="address")
	private String Address;

	public TableToImportInExcel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TableToImportInExcel(Integer applicantId, Integer applicanttypeid, String city, String address) {
		super();
		ApplicantId = applicantId;
		Applicanttypeid = applicanttypeid;
		City = city;
		Address = address;
	}

	public Integer getApplicantId() {
		return ApplicantId;
	}

	public void setApplicantId(Integer applicantId) {
		ApplicantId = applicantId;
	}

	public Integer getApplicanttypeid() {
		return Applicanttypeid;
	}

	public void setApplicanttypeid(Integer applicanttypeid) {
		Applicanttypeid = applicanttypeid;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}
	
	

}
