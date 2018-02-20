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

import com.restaurant.c1603g.Entity.manage.Receptionist;
import com.restaurant.c1603g.Service.manage.ReceptionistService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ReceptionistController {
	
	@Autowired
	ReceptionistService receptionistService;
	
	@GetMapping("/get/receptionist")
	public Receptionist getReceptionist(@RequestParam("Id") String id ) {
		return receptionistService.getReceptionist(id);
	}
	
	@GetMapping("/get/receptionists")
	public List<Receptionist> getManyReceptionistByName(@RequestParam("name") String name) {
		return receptionistService.getManyReceptionistByName(name);
	}
	
	@PostMapping("/insert/receptionist")
	public String insertReceptionist(@RequestBody Receptionist receptionist) {
		return receptionistService.insertReceptionist(receptionist);
	}
	@PostMapping("/update/receptionist")
	public String updateReceptionist(@RequestBody Receptionist receptionis) {
		return receptionistService.updateReceptionist(receptionis);
	}
	
	@PostMapping("/delete/receptionist")
	public String deleteReceptionist(@RequestParam("Id") String id) {
		return receptionistService.deleteReceptionist(id);
	}
	
}
