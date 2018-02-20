package com.restaurant.c1603g.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.restaurant.c1603g.Entity.other.EntityService;
import com.restaurant.c1603g.Factory.OtherServiceFactory;

@Service
public class OtherService {

	public EntityService getService(String id) {
		return new OtherServiceFactory().getEntity(id);
	}

	public List<EntityService> getManyServiceByName(String name) {
		return new OtherServiceFactory().getManyEntityByName(name);
	}

	public String insertService(EntityService service) {
		return new OtherServiceFactory().insertEntity(service);
	}

	public String updateService(EntityService service) {
		return new OtherServiceFactory().updateEntity(service);
	}

	public String deleteService(String id) {
		return new OtherServiceFactory().deleteEntity(id);
	}
	
	
	
}
