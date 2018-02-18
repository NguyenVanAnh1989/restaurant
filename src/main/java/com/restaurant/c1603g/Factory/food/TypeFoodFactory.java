package com.restaurant.c1603g.Factory.food;

import java.util.List;

import com.restaurant.c1603g.DAO.CommonDAO;
import com.restaurant.c1603g.DAO.food.TypeFoodDao;
import com.restaurant.c1603g.Entity.food.TypeFood;
import com.restaurant.c1603g.Entity.other.DeclareId;
import com.restaurant.c1603g.Factory.InterfaceFactory.CrudEntity;

public class TypeFoodFactory implements CrudEntity<TypeFood>{

	@Override
	public String insertEntity(TypeFood typeFood) {
		DeclareId declare = new CommonDAO().getIdOfEntity("TF");
		typeFood.setId(declare.toString());
		if(new TypeFoodDao().insertEntity(typeFood) != null) {
			new CommonDAO().updateIdOfEntity(declare.getNameId(),declare.getValue());
			return "Success Full Insert";
		}else {
			return "Not Success Full can be duplicate or Fail some thing";
		}
	}

	@Override
	public String updateEntity(TypeFood e) {
		return new TypeFoodDao().updateEntity(e);
	}

	@Override
	public String deleteEntity(String id) {
		return new TypeFoodDao().deleteEntity(id);
	}

	@Override
	public TypeFood getEntity(String id) {
		return new TypeFoodDao().getEntityById(id);
	}

	@Override
	public List<TypeFood> getAllEntity(String name) {
		return new TypeFoodDao().getManyEntityByName(name);
	}


}
