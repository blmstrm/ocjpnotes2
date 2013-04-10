package com.blmstrm.ocjp2;
import com.blmstrm.ocjp2.cupboard.Cupboard;
import com.blmstrm.ocjp2.meals.Meal;
import com.blmstrm.ocjp2.meals.MealFactory;
import com.blmstrm.ocjp2.plates.Plate;

public class TestMealFactory {
	public static void main(String args[]){


		MealFactory myMealFactory = new MealFactory();
		Cupboard kitchenCupboard = new Cupboard();

		kitchenCupboard.clearOut();

		Meal cookedMeal = myMealFactory.cookAMeal();

		System.out.println(cookedMeal.getType()+" is ready!");

		Plate plate = Plate.create();
			
		plate.plateFood(cookedMeal);

		System.out.println(plate);

		kitchenCupboard.putAway(plate);

		Plate dirtyPlate = (Plate) kitchenCupboard.get();
		
		System.out.println(dirtyPlate);
		
		dirtyPlate.clean();
		
		System.out.println(dirtyPlate);

	}
}
