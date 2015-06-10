package com.pincode.model;

public class MongoModel {
	String officeName, officetype, divisionName, regionNAme, circleName, taluk,
			districtName, stateName;
	long pincode;

	public MongoModel() {
		super();
		this.officeName = "";
		this.officetype = "";
		this.divisionName = "";
		this.regionNAme = "";
		this.circleName = "";
		this.taluk = "";
		this.districtName = "";
		this.stateName = "";
		this.pincode = (long) 0;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	public String getOfficetype() {
		return officetype;
	}

	public void setOfficetype(String officetype) {
		this.officetype = officetype;
	}

	public String getDivisionName() {
		return divisionName;
	}

	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

	public String getRegionNAme() {
		return regionNAme;
	}

	public void setRegionNAme(String regionNAme) {
		this.regionNAme = regionNAme;
	}

	public String getCircleName() {
		return circleName;
	}

	public void setCircleName(String circleName) {
		this.circleName = circleName;
	}

	public String getTaluk() {
		return taluk;
	}

	public void setTaluk(String taluk) {
		this.taluk = taluk;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public long getPincode() {
		return pincode;
	}

	public void setPincode(long pincode) {
		this.pincode = pincode;
	}

}
