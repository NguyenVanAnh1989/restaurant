package com.restaurant.c1603g.Factory;

import java.util.List;

import com.restaurant.c1603g.Entity.Food;
import com.restaurant.c1603g.Factory.InterfaceFactory.CrudEntity;

public class FoodFactory implements CrudEntity<Food>{


	@Override
	public boolean insertEntity(Food food) {	
		return false;
	}

	@Override
	public boolean updateEntity(Food t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteEntity(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Food getFood(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Food> getAllFood(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
