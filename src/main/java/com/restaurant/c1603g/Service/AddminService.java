package com.restaurant.c1603g.Service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.restaurant.c1603g.Entity.manage.Addmin;
import com.restaurant.c1603g.Factory.AddminFactory;

@Service
public class AddminService {
	
	public Addmin getAddminById(String id) {
		return new AddminFactory().getEntity(id);
	}
	
	public List<Addmin> getAddminByName(String name){
		return new AddminFactory().getManyEntityByName(name);
	}
	
	public String insertAddmin(Addmin addmin) {
		return new AddminFactory().insertEntity(addmin);
	}
	
	public String updateAddmin(Addmin addmin) {
		return new AddminFactory().updateEntity(addmin);
	}
	
	public String deleteAddmin(String id) {
		return new AddminFactory().deleteEntity(id);
	}
	
	
}
