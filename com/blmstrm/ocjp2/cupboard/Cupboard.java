package com.blmstrm.ocjp2.cupboard;

import java.net.UnknownHostException;

import com.blmstrm.ocjp2.plates.*;
import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.mongodb.Mongo;


public class Cupboard {
	Mongo mongo;
	Morphia morphia;
	Datastore cupboard;
	{
		try {
			mongo = new Mongo();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		morphia = new Morphia();
		morphia.map(PlateWrapper.class);
		cupboard = morphia.createDatastore(mongo, "great");

	}

	public void putAwayPlate(Plate p){
		//p.clean();
		PlateWrapper wrapper = new PlateWrapper();
		wrapper.plate = p;
		cupboard.save(wrapper);
		System.out.println("Put plate in cupboard.");
	}

	public Plate getPlate(){
		System.out.println("Removed plate from cupboard.");
		return (cupboard.find(PlateWrapper.class).get()).plate;
	}
	
}
