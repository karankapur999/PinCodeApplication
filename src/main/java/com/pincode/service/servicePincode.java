package com.pincode.service;

import java.util.ArrayList;
import java.util.Set;

import com.pincode.model.MongoModel;
import com.pincode.model.Values;

public interface servicePincode {
	public ArrayList<ArrayList<MongoModel>> getPincodeData(Values obj);

}
