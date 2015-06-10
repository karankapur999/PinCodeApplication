package com.pincode.model;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;

public class MongoConnectionStatic {
	static {
		Mongo m = null;
		try {
			m = new Mongo();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DB db = m.getDB("Pincode");
		DBCollection coll = db.getCollection("master_data");

	}

}
