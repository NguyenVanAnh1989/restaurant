package com.restaurant.c1603g.Service.manage;

import java.util.List;

import org.springframework.stereotype.Service;
import com.restaurant.c1603g.Entity.manage.Receptionist;
import com.restaurant.c1603g.Factory.manage.ReceptionistFactory;

@Service
public class ReceptionistService {
	
	public Receptionist getReceptionist(String id) {
		return new ReceptionistFactory().getEntity(id);
	}
	
	public List<Receptionist> getManyReceptionistByName(String name) {
		return new ReceptionistFactory().getManyEntityByName(name);
	}
	
	public String insertReceptionist(Receptionist receptionist) {
		return new ReceptionistFactory().insertEntity(receptionist);
	}
	
	public String updateReceptionist(Receptionist receptionist) {
		return new ReceptionistFactory().updateEntity(receptionist);
	}
	
	public String deleteReceptionist(String id) {
		return new ReceptionistFactory().deleteEntity(id);
	}
	
}
