package com.restaurant.c1603g.Service.food;

import java.util.List;

import org.springframework.stereotype.Service;

import com.restaurant.c1603g.Entity.food.Food;
import com.restaurant.c1603g.Factory.food.FoodFactory;


@Service
public class FoodService {
	
	public Food getFoodById(String id) {
		return new FoodFactory().getEntity(id);

	}
	
	
	public boolean insertFood() {
		return false;
	}
	
	public boolean deleteFood() {
		return false;
	}
	
	public boolean updateFood() {
		return false;
	}

	public List<Food> getFoodsByName(String name) {
		return new FoodFactory().getAllEntity(name);
	}
	
	public String insertFood(Food food) {
		return new FoodFactory().insertEntity(food);
	}
	
	public String updateFood(Food food) {	
		return new FoodFactory().updateEntity(food);
	}
	
	public String deleteFood(String id) {
		return new FoodFactory().deleteEntity(id);

	}
}
