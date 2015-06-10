package com.pincode.model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ModelFromResponseBody {

	public Values getModelFromResponseBody(String JSON_DATA)
			throws ParseException {
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(JSON_DATA);
		JSONObject object = (JSONObject) obj;
		/*
		 * System.out.println(object.get("Pincode"));
		 * System.out.println(object.get("state"));
		 * System.out.println(object.get("districtName"));
		 */
		Values form = new Values();
		try {

			if (object.get("state") != null && object.get("state") != "")
				form.setState((String) object.get("state"));
			if (object.get("districtName") != null
					&& object.get("districtName") != "")
				form.setDistrictname((String) object.get("districtName"));

			if ((long) object.get("Pincode") != 0
					&& object.get("Pincode") != null)
				form.setPincode((Long) object.get("Pincode"));
		} catch (Exception e) {

		}
		return form;

	}

}
