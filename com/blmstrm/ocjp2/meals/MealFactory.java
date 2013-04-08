package com.blmstrm.ocjp2.meals;
import java.util.Calendar;

public class MealFactory {
	private static Calendar calendar;

	{
		calendar = Calendar.getInstance();
	}

	public Meal cookAMeal(){

		int hour = calendar.get(Calendar.HOUR_OF_DAY);

		if(hour >= 0 && hour <= 10){
			return new Breakfast();
		}else if(hour <= 15){
			return new Lunch();
		}

		return new Dinner();
	}
}
