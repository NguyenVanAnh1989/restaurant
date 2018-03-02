package com.restaurant.c1603g.Service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.restaurant.c1603g.Entity.manage.Admin;
import com.restaurant.c1603g.Factory.AdminFactory;

@Service
public class AdminService {
	
	public Admin getAdminById(String id) {
		return new AdminFactory().getEntity(id);
	}
	
	public List<Admin> getAdminByName(String name){
		return new AdminFactory().getManyEntityByName(name);
	}
	
	public String insertAdmin(Admin admin) {
		return new AdminFactory().insertEntity(admin);
	}
	
	public String updateAdmin(Admin admin) {
		return new AdminFactory().updateEntity(admin);
	}
	
	public String deleteAdmin(String id) {
		return new AdminFactory().deleteEntity(id);
	}

	public String checkAdmin(Admin admin) {
		return new AdminFactory().checkAdmin(admin);
	}
	
	
}
