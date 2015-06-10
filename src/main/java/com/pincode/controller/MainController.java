package com.pincode.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pincode.model.MongoModel;
import com.pincode.model.Values;
import com.pincode.service.servicePincode;

@Controller
public class MainController {

	@Autowired
	servicePincode injection;

	@RequestMapping(value = "/fetching", method = RequestMethod.POST)
	public String fetchData(@ModelAttribute Values form, BindingResult result,
			Map<String, Object> map) {

		map.put("response", injection.getPincodeData(form));

		return "panel";
	}

	@RequestMapping(value = "/fetching")
	public String defaultData(@ModelAttribute Values form,
			BindingResult result, Map<String, Object> map) {

		return "panel";
	}

	@RequestMapping("/getPincodeData")
	public @ResponseBody Object gettingJson(
			@RequestParam(required = false) String state,
			@RequestParam(required = false) String Districtname,
			@RequestParam(required = false) Integer Pincode) {
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
					form.setPincode(Pincode);
			} catch (Exception e) {

			}

			return injection.getPincodeData(form);
		} catch (Exception e) {
			System.out.println("This is exception" + e);
			return "";
		}
	}

}
