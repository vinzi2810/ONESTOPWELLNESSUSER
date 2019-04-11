package com.pojo;

public class DoctorDetails {
	private String doctorName;
	private String specialization;
	
	public DoctorDetails(String doctorName, String specialization) {
		super();
		this.doctorName = doctorName;
		this.specialization = specialization;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

}
