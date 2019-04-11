package com.pojo;

public class HospitalDetails {
	String hospitalName;
	String hospitalLocation;
	
	public HospitalDetails(String hospitalName, String hospitalLocation) {
		super();
		this.hospitalName = hospitalName;
		this.hospitalLocation = hospitalLocation;
	}	
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public String getHospitalLocation() {
		return hospitalLocation;
	}
	public void setHospitalLocation(String hospitalLocation) {
		this.hospitalLocation = hospitalLocation;
	}
	
	

}
