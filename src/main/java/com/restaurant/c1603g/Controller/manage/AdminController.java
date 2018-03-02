package com.restaurant.c1603g.Controller.manage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.c1603g.Entity.manage.Admin;
import com.restaurant.c1603g.Service.AdminService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class AdminController {

	@Autowired
	AdminService adminService;
	
	@GetMapping("/get/admin")
	public Admin getAddminById(@RequestParam("Id") String id) {
		return adminService.getAdminById(id);
	}
	
	@GetMapping("/get/admins")
	public List<Admin> getListAddminByName(@RequestParam("name") String name) {
		return adminService.getAdminByName(name);
	}
	
	@PostMapping("/insert/admin")
	public String insertAddmin(@RequestBody Admin admin) {
		return adminService.insertAdmin(admin);
	}
	
	@PostMapping("/update/admin")
	public String updateAddmin(@RequestBody Admin admin) {
		return adminService.updateAdmin(admin);
	}
	
	@PostMapping("/delete/admin")
	public String deleteAddmin(@RequestParam("Id") String id) {
		return adminService.deleteAdmin(id);
	}
	
	@PostMapping("/check/admin")
	public String deleteAddmin(@RequestBody Admin admin) {
		return adminService.checkAdmin(admin);
	}
	
	
}
