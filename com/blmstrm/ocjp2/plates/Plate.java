package com.blmstrm.ocjp2.plates;

import java.util.Calendar;

import com.blmstrm.ocjp2.KitchenWare;
import com.blmstrm.ocjp2.meals.Meal;
import com.google.code.morphia.annotations.Embedded;

@Embedded
public enum Plate implements KitchenWare{

	BREAKFAST,LUNCH,DINNER;

	private Meal plateContent;
	private boolean dirty;
	private static Calendar calendar = Calendar.getInstance();


	public void plateFood(Meal food){
		this.plateContent = food;
		this.dirty = true;
		System.out.println("Put "+plateContent.getType()+" on plate.");
	}

	public Meal getPlateContent(){
		return plateContent;
	}

	public void clean() {
		this.plateContent = null;	
		System.out.println("Cleaned plate.");
	}

	public boolean isDirty(){
		return this.dirty;
	}

	@Override
	public String toString(){
		if(plateContent!=null){
			return "There is "+this.plateContent.getType()+" on the plate.";
		}
		return "There is nothing on the plate.";
	}

	@Override
	public void use() {
		/* Not used at the moment*/
	}

	public static Plate create(){
		int hour = calendar.get(Calendar.HOUR_OF_DAY);

		if(hour >= 0 && hour <= 10){
			return BREAKFAST;
		}else if(hour <= 15){
			return LUNCH;
		}
		return DINNER;
	}

}
