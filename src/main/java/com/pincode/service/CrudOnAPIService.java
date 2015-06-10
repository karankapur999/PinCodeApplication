package com.pincode.service;

import java.util.ArrayList;

import com.pincode.model.MongoModel;
import com.pincode.model.Values;

public interface CrudOnAPIService {
	public ArrayList<MongoModel> getPincodeData(Values obj);

	public String savePincodeData(MongoModel model);
	public String deletePincodeData(Values obj);

}
