package com.blmstrm.ocjp2.cupboard;

import java.net.UnknownHostException;

import com.blmstrm.ocjp2.utensils.KitchenWare;
import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;


public class Cupboard {
	Mongo mongo;
	Morphia morphia;
	Datastore cupboard;
	String dbName = "kitchen";
	{
		try { 
			mongo = new Mongo();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		morphia = new Morphia();
		morphia.map(KitchenWareWrapper.class);
				cupboard = morphia.createDatastore(mongo, dbName);
	}
	
	public void putAway(KitchenWare k){

		KitchenWareWrapper wrapper = new KitchenWareWrapper();
		
		wrapper.setKitchenWare(k);
		
		cupboard.save(wrapper);
		System.out.println("Put plate in cupboard.");
	}

	public KitchenWare get(){
		return (cupboard.find(KitchenWareWrapper.class).get()).getKitchenWare();
	}
	
	public void clearOut(){
		mongo.dropDatabase(dbName);
	}
		
}
