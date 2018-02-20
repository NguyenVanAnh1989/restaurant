package com.restaurant.c1603g.Controller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.c1603g.Entity.other.EntityService;
import com.restaurant.c1603g.Service.OtherService;


@RestController
@CrossOrigin
@RequestMapping("/api")
public class ServiceController {

	@Autowired
	OtherService otherService;
	
	@GetMapping("/get/Service")
	public EntityService getService(@RequestParam("Id") String id) {
		return otherService.getService(id);
	}

	@GetMapping("/get/Services")
	public List<EntityService> getListService(@RequestParam("name") String name) {
		return otherService.getManyServiceByName(name);
	}

	@PostMapping("/insert/Service")
	public String insertService(@RequestBody EntityService service) {
		return otherService.insertService(service);
	}

	@PostMapping("/update/Service")
	public String updateService(@RequestBody EntityService service) {
		return otherService.updateService(service);
	}

	@PostMapping("/delete/Service")
	public String deleteService(@RequestParam("Id") String id) {
		return otherService.deleteService(id);
	}

}
