package com.blmstrm.ocjp2.plates;

import com.blmstrm.ocjp2.meals.Meal;

public interface Plate {
		
	public void plateFood(Meal food);

	public Meal getPlateContent();

	public void clean();
		
}
