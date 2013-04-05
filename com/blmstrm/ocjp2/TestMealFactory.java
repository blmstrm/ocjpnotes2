package com.blmstrm.ocjp2;
import com.blmstrm.ocjp2.meals.Meal;
import com.blmstrm.ocjp2.meals.MealFactory;

public class TestMealFactory {
	public static void main(String args[]){
		
		MealFactory myMealFactory = new MealFactory();
		Meal cookedMeal = myMealFactory.cookAMeal();
		
		System.out.println(cookedMeal.getType()+" is ready!");
	
	}
}
