package com.restaurant.c1603g.Factory;

import java.util.List;
import com.restaurant.c1603g.DAO.TypeFoodDao;
import com.restaurant.c1603g.Entity.TypeFood;
import com.restaurant.c1603g.Factory.InterfaceFactory.CrudEntity;

public class TypeFoodFactory implements CrudEntity<TypeFood>{

	@Override
	public TypeFood getFood(String id) {
		return new TypeFoodDao().getTypeFoodById(id);
	}

	@Override
	public boolean insertEntity(TypeFood typeFood) {
		String idTypeFood = new String(new FactoryCommon().getDataInFile("D:/Id.txt"));
		idTypeFood = new FactoryCommon().resolveTextAndInteger("FD",idTypeFood.trim());
		typeFood.setId(idTypeFood.trim());
		return new TypeFoodDao().insert(typeFood);
	}

	@Override
	public boolean updateEntity(TypeFood e) {
		return new TypeFoodDao().updateTypeFood(e);
	}

	@Override
	public boolean deleteEntity(String id) {
		return new TypeFoodDao().deleteTypeFood(id);
	}

	@Override
	public List<TypeFood> getAllFood(String name) {
		return new TypeFoodDao().getTypeFoodByName(name);
	}


}
