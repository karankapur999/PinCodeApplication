package com.pincode.service.impl;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import org.dom4j.rule.Mode;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.pincode.model.MongoModel;
import com.pincode.model.MongoResultObject;
import com.pincode.model.Values;
import com.pincode.service.CrudOnAPIService;

@Service
public class CrudOnAPIServiceImpl implements CrudOnAPIService {

	ApiResources object = new ApiResources();

	Map getQueryMap(Values obj) {
		Map<Object, Object> mp = new HashMap();
		if (obj.getDistrictname() != null && obj.getDistrictname() != "") {
			mp.put("Districtname", Pattern.compile(obj.getDistrictname(),
					Pattern.CASE_INSENSITIVE));
		}
		if (obj.getState() != null && obj.getState() != "") {
			mp.put("statename",
					Pattern.compile(obj.getState(), Pattern.CASE_INSENSITIVE));
		}
		if (obj.getPincode() != 0) {
			mp.put("pincode", obj.getPincode());
		}

		return mp;
	}

	@Override
	public ArrayList<MongoModel> getPincodeData(Values obj) {
		ArrayList<MongoModel> document = null;
		//ArrayList<ArrayList<MongoModel>> dbmapping = new ArrayList<ArrayList<MongoModel>>();
		Mongo m = null;
		try {
			m = new Mongo();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DB db = m.getDB(object.DB_NAME);
		DBCollection coll = db.getCollection(object.PERSON_COLLECTION);
		System.out.println("this is the querymap" + getQueryMap(obj));

		// adding data
		BasicDBObject inQuery = new BasicDBObject();

		inQuery.putAll((getQueryMap(obj)));

		DBCursor cursor = coll.find(inQuery);

		MongoResultObject object = new MongoResultObject();

		while (cursor.hasNext()) {
			document = new ArrayList<MongoModel>();

			try {

				document.add(object.getMongoResultObject(cursor.next()));

			} catch (Exception e) {
				System.out.println(e);
				m.close();

			}

			

		}
		m.close();

		return document;
	}

	@Override
	public String savePincodeData(MongoModel model) {

		MongoClient mongo = null;
		try {

			mongo = new MongoClient(object.MONGO_HOST, object.MONGO_PORT);
			MongoOperations mongoOps = new MongoTemplate(mongo, object.DB_NAME);

			mongoOps.save(model, object.PERSON_COLLECTION);

		} catch (UnknownHostException e) {
			
			mongo.close();
			return "Failure";
		}
		mongo.close();

		return "true";
	}

	@Override
	public String deletePincodeData(Values obj) {

		try {
			Mongo m = null;
			try {
				m = new Mongo();
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			DB db = m.getDB(object.DB_NAME);
			DBCollection coll = db.getCollection(object.PERSON_COLLECTION);
			BasicDBObject inQuery = new BasicDBObject();

			inQuery.putAll((getQueryMap(obj)));
			coll.remove(inQuery);
		} catch (Exception e) {
			return "Failure Aborted";
		}

		return "Successfully Deleted";
	}
}
