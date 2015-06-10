package com.pincode.model;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;

public class MongoResultObject {

	public MongoModel getMongoResultObject(Object jsonData)
			throws ParseException {
		MongoModel model = new MongoModel();
		JSONParser parser = new JSONParser();
		Gson gson = new Gson();
		String jsonString = gson.toJson(jsonData);

		Object obj = parser.parse(jsonString);
		JSONObject object = (JSONObject) obj;

		model.setCircleName((String) object.get("circlename"));
		model.setOfficeName((String) object.get("officename"));
		model.setDivisionName((String) object.get("divisionname"));

		model.setTaluk((String) object.get("Taluk"));
		model.setDistrictName((String) object.get("Districtname"));
		model.setStateName((String) object.get("statename"));
		model.setPincode((long) object.get("pincode"));

		return model;

	}

}
