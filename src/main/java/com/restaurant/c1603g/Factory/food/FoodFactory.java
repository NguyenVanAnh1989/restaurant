package com.restaurant.c1603g.Factory.food;

import java.util.List;

import com.restaurant.c1603g.Constant.LogInfo;
import com.restaurant.c1603g.DAO.CommonDAO;
import com.restaurant.c1603g.DAO.food.FoodDAO;
import com.restaurant.c1603g.Entity.food.Food;
import com.restaurant.c1603g.Entity.other.DeclareId;
import com.restaurant.c1603g.Factory.InterfaceFactory.CrudEntity;

public class FoodFactory implements CrudEntity<Food> {

	@Override
	public String insertEntity(Food food) {
		DeclareId declare = new CommonDAO().getIdOfEntity("FD");
		food.setId(declare.toString());
		String info = new FoodDAO().insertEntity(food);
		if (info.equals(LogInfo.SUCCESS_FULL)) {
			new CommonDAO().updateIdOfEntity(declare.getNameId(), declare.getValue());
			return info;
		} else {
			return info;
		}

	}

	@Override
	public String updateEntity(Food food) {
		return new FoodDAO().updateEntity(food);
	}

	@Override
	public String deleteEntity(String id) {
		return new FoodDAO().deleteEntity(id);
	}

	@Override
	public Food getEntity(String id) {
		return new FoodDAO().getEntityById(id);
	}

	@Override
	public List<Food> getManyEntityByName(String name) {
		return new FoodDAO().getManyEntityByName(name);
	}

}
