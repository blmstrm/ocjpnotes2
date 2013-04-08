package com.blmstrm.ocjp2.plates;

import com.blmstrm.ocjp2.meals.Meal;

public enum Plate{

	BREAKFAST,LUNCH,DINNER;

	private Meal plateContent;
	private boolean dirty;

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

}
