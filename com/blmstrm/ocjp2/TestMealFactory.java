package com.blmstrm.ocjp2;
import com.blmstrm.ocjp2.cupboard.Cupboard;
import com.blmstrm.ocjp2.meals.Meal;
import com.blmstrm.ocjp2.meals.MealFactory;
import com.blmstrm.ocjp2.plates.Plate;
import com.blmstrm.ocjp2.possessions.Basket;
import com.blmstrm.ocjp2.possessions.Camera;
import com.blmstrm.ocjp2.possessions.Photo;
import com.blmstrm.ocjp2.possessions.PhotoAlbum;
import com.blmstrm.ocjp2.utensils.Fork;
import com.blmstrm.ocjp2.utensils.KitchenWare;
import com.blmstrm.ocjp2.utensils.Knife;

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

		dirtyPlate.plateFood(cookedMeal);

		Basket picknickBasket = new Basket();

		Fork fork = new Fork();
		fork.setBrand("Gucchi");

		Knife knife = new Knife();
		knife.setBrand("Dolce & Gabbana");

		picknickBasket.addKitchenWare("Kantas plate", dirtyPlate);
		picknickBasket.addKitchenWare("Ankas fork", fork);
		picknickBasket.addKitchenWare("Drogbas knife", knife);

		for(KitchenWare k : picknickBasket.getEveryWareFromTo("K", "L")){
			System.out.println(k);
		}
		
		Camera camera = new Camera();
		Photo foodPhoto= new Photo();

		foodPhoto.addObject(fork);
		foodPhoto.addObject(knife);
		
		camera.snapAPhoto(foodPhoto);
		
		PhotoAlbum album = new PhotoAlbum();
		album.flipTrough();
		
		
	}
}
