package com.restaurant.c1603g.Factory;

import java.util.List;

import com.restaurant.c1603g.DAO.TypeFoodDao;
import com.restaurant.c1603g.Entity.TypeFood;
import com.restaurant.c1603g.Factory.InterfaceFactory.CrudEntity;

public class TypeFoodFactory implements CrudEntity<TypeFood>{

	@Override
	public TypeFood getFood(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TypeFood> getAllFood() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertEntity(TypeFood e) {
		return new TypeFoodDao().insert(e);
	}

	@Override
	public boolean updateEntity(TypeFood e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteEntity(String id) {
		// TODO Auto-generated method stub
		return false;
	}

}
