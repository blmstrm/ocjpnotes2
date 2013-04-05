package com.blmstrm.ocjp2.meals;

public abstract class Meal {
	{
		this.cook();
	}

	public void cook(){
		System.out.println("Cooking "+this.getType()+".");
	};
	
	public abstract String getType();
	
}
