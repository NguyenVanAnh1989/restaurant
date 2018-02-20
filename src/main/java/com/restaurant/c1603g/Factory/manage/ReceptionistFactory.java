package com.restaurant.c1603g.Factory.manage;

import java.util.List;

import com.restaurant.c1603g.DAO.CommonDAO;
import com.restaurant.c1603g.DAO.manage.ReceptionistDAO;
import com.restaurant.c1603g.Entity.manage.Receptionist;
import com.restaurant.c1603g.Entity.other.DeclareId;
import com.restaurant.c1603g.Factory.InterfaceFactory.CrudEntity;

public class ReceptionistFactory implements CrudEntity<Receptionist> {

	@Override
	public Receptionist getEntity(String id) {
		return new ReceptionistDAO().getEntityById(id);
	}

	@Override
	public List<Receptionist> getManyEntityByName(String name) {
		return new ReceptionistDAO().getManyEntityByName(name);
	}

	@Override
	public String insertEntity(Receptionist receptionist) {
		DeclareId declare = new CommonDAO().getIdOfEntity("RC");
		receptionist.setId(declare.toString());
		String info = new ReceptionistDAO().insertEntity(receptionist);
		if(!info.equals("Exception") && info != null) {
			new CommonDAO().updateIdOfEntity(declare.getNameId(),declare.getValue());
			return "Successfull Done Ok";
		}else {
			return "Not Done Now Exception call";
		}		
	}

	@Override
	public String updateEntity(Receptionist receptionist) {
		return new ReceptionistDAO().updateEntity(receptionist);
	}

	@Override
	public String deleteEntity(String id) {
		return new ReceptionistDAO().deleteEntity(id);
	}
	
}
