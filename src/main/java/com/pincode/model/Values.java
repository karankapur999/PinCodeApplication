package com.pincode.model;

public class Values {
	long pincode;
	String state, districtname;

	public Values() {
		this.pincode =  0;
		this.state = "";
		this.districtname = "";

	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDistrictname() {
		return districtname;
	}

	public void setDistrictname(String districtname) {
		this.districtname = districtname;
	}

	public Long getPincode() {
		return pincode;
	}

	public void setPincode(Long long1) {
		this.pincode = long1;
	}

}
