package com.pincode.controller;

import java.util.ArrayList;
import java.util.Map;

import javax.xml.ws.Response;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pincode.model.ModelFromResponseBody;
import com.pincode.model.MongoModel;
import com.pincode.model.Values;
import com.pincode.service.CrudOnAPIService;

@Controller
public class CrudApiOnPincodeDirectory {

	ModelFromResponseBody obj = new ModelFromResponseBody();
	@Autowired
	CrudOnAPIService injection;

	@RequestMapping("/getPincodeDirectoryData")
	public @ResponseBody Object getPincodeData(
			@RequestParam(required = false) String state,
			@RequestParam(required = false) String Districtname,
			@RequestParam(required = true) Integer Pincode) {
		try {
			System.out.println("This is District" + Pincode);
			Values form = new Values();
			try {
				System.out.println(state + ">" + Districtname + ">" + Pincode);
				if (state != null && state != "")
					form.setState(state);
				if (Districtname != null && Districtname != "")
					form.setDistrictname(Districtname);
				if (Pincode != null && Pincode != 0)
					form.setPincode((long) Pincode);
			} catch (Exception e) {

			}

			return injection.getPincodeData(form);
		} catch (Exception e) {
			System.out.println("This is exception" + e);
			return "";
		}
	}

	@RequestMapping("/deletePincodeDirectoryData")
	public @ResponseBody Object deleteDataStatus(
			@RequestParam(required = false) String state,
			@RequestParam(required = false) String Districtname,
			@RequestParam(required = false) long Pincode) {
		try {
			System.out.println("This is District" + Pincode);
			Values form = new Values();
			try {
				System.out.println(state + ">" + Districtname + ">" + Pincode);
				if (state != null && state != "")
					form.setState(state);
				if (Districtname != null && Districtname != "")
					form.setDistrictname(Districtname);
				if (Pincode != 0)
					form.setPincode((long) Pincode);
			} catch (Exception e) {

			}

			return injection.getPincodeData(form);
		} catch (Exception e) {
			System.out.println("This is exception" + e);
			return "";
		}
	}

	@RequestMapping("/savePincodeData")
	public @ResponseBody Object savingPinCode(
			@RequestParam(required = true) String statename,
			@RequestParam(required = true) String Districtname,
			@RequestParam(required = false) String officeName,
			@RequestParam(required = false) String officetype,
			@RequestParam(required = false) String divisionName,
			@RequestParam(required = false) String regionName,
			@RequestParam(required = false) String circleName,
			@RequestParam(required = false) String taluk,

			@RequestParam(required = true) Long Pincode) {
		try {
			System.out.println("This is District" + Pincode);
			MongoModel form = new MongoModel();
			try {

				if (statename != null && statename != "")

					form.setStateName(statename);
				if (Districtname != null && Districtname != "")
					form.setDistrictName(Districtname);
				if (Pincode != null && Pincode != 0)
					form.setPincode(Pincode);

				if (officeName != null && officeName != "")

					form.setOfficeName(officeName);
				if (regionName != null && regionName != "")
					form.setRegionNAme(regionName);
				if (Pincode != null && Pincode != 0)
					form.setPincode(Pincode);
				if (taluk != null && taluk != "")

					form.setTaluk(taluk);
				if (divisionName != null && divisionName != "")
					form.setDivisionName(divisionName);
				if (officetype != null && officetype != "")
					form.setOfficetype(officetype);

			} catch (Exception e) {

			}
			return injection.savePincodeData(form);

		} catch (Exception e) {
			System.out.println("This is exception>" + e);
			return "Error ";
		}
	}
	@ResponseBody
	@RequestMapping(value = "/getPincodeDataCurl")
	public ArrayList<MongoModel> addOptional(@RequestBody String requestJSON)
			throws ParseException {
		try {
			
			//System.out.println(obj.getModelFromResponseBody(requestJSON));
			return injection.getPincodeData(obj
					.getModelFromResponseBody(requestJSON));
		} catch (Exception e) {
			System.out.println("Exception:-" + e);
			return null;
		}

	}

}
