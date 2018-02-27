package com.restaurant.c1603g.Factory;

import java.util.List;

import com.restaurant.c1603g.DAO.AddminDAO;
import com.restaurant.c1603g.DAO.CommonDAO;
import com.restaurant.c1603g.Entity.manage.Addmin;
import com.restaurant.c1603g.Entity.other.DeclareId;
import com.restaurant.c1603g.Factory.InterfaceFactory.CrudEntity;

public class AddminFactory implements CrudEntity<Addmin>{

	@Override
	public Addmin getEntity(String id) {
		return new AddminDAO().getEntityById(id);
	}

	@Override
	public List<Addmin> getManyEntityByName(String name) {
		return new AddminDAO().getManyEntityByName(name);
	}

	@Override
	public String insertEntity(Addmin addmin) {
		DeclareId declare = new CommonDAO().getIdOfEntity("AM");
		addmin.setId(declare.toString());
		String info = new AddminDAO().insertEntity(addmin);
		if(!info.equals("Exception") && info != null) {
			new CommonDAO().updateIdOfEntity(declare.getNameId(),declare.getValue());
			return "Successfull Done Ok";
		}else {
			return "Not Done Now Exception call";
		}		
	}

	@Override
	public String updateEntity(Addmin addmin) {
		return new AddminDAO().updateEntity(addmin);
	}

	@Override
	public String deleteEntity(String id) {
		return new AddminDAO().deleteEntity(id);
	}

}
