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

import com.restaurant.c1603g.Entity.manage.Addmin;
import com.restaurant.c1603g.Service.AddminService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class AddminController {

	@Autowired
	AddminService addminService;
	
	@GetMapping("/get/addmin")
	public Addmin getAddminById(@RequestParam("Id") String id) {
		return addminService.getAddminById(id);
	}
	
	@GetMapping("/get/addmins")
	public List<Addmin> getListAddminByName(@RequestParam("name") String name) {
		return addminService.getAddminByName(name);
	}
	
	@PostMapping("/insert/addmin")
	public String insertAddmin(@RequestBody Addmin addmin) {
		return addminService.insertAddmin(addmin);
	}
	
	@PostMapping("/update/addmin")
	public String updateAddmin(@RequestBody Addmin addmin) {
		return addminService.updateAddmin(addmin);
	}
	
	@PostMapping("/delete/addmin")
	public String deleteAddmin(@RequestParam("Id") String id) {
		return addminService.deleteAddmin(id);
	}
}
