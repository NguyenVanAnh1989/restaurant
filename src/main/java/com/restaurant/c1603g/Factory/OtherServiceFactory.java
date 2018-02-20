package com.restaurant.c1603g.Factory;

import java.util.List;

import com.restaurant.c1603g.DAO.CommonDAO;
import com.restaurant.c1603g.DAO.other.ServiceDAO;
import com.restaurant.c1603g.Entity.other.DeclareId;
import com.restaurant.c1603g.Entity.other.EntityService;
import com.restaurant.c1603g.Factory.InterfaceFactory.CrudEntity;

public class OtherServiceFactory implements CrudEntity<EntityService>{

	@Override
	public EntityService getEntity(String id) {
		return new ServiceDAO().getEntityById(id);
	}
	
	@Override
	public List<EntityService> getManyEntityByName(String name) {
		return new ServiceDAO().getManyEntityByName(name);
	}

	@Override
	public String insertEntity(EntityService entityService) {
		DeclareId declare = new CommonDAO().getIdOfEntity("SV");
		entityService.setId(declare.toString());
		String info = new ServiceDAO().insertEntity(entityService);
		if(!info.equals("Exception") && info != null) {
			new CommonDAO().updateIdOfEntity(declare.getNameId(),declare.getValue());
			return "Successfull Done Ok";
		}else {
			return "Not Done Now Exception call";
		}		
	}

	@Override
	public String updateEntity(EntityService service) {
		return new ServiceDAO().updateEntity(service);
	}

	@Override
	public String deleteEntity(String id) {
		return new ServiceDAO().deleteEntity(id);
	}


	
	
}
