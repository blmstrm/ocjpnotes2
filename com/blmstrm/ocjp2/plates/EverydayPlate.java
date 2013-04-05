package com.blmstrm.ocjp2.plates;

import com.blmstrm.ocjp2.meals.Meal;

public enum EverydayPlate implements Plate {

	INSTANCE;
	
	private Meal plateContent;
		
	public void plateFood(Meal food){
		this.plateContent = food;
		System.out.println("Put "+plateContent.getType()+" on plate.");
	}
	
	public Meal getPlateContent(){
		return plateContent;
	}

	public void clean() {
	this.plateContent = null;	
	System.out.println("Cleaned plate.");
	}
	@Override
	public String toString(){
		return "There is "+this.plateContent.getType()+" on the plate.";
	}

}
