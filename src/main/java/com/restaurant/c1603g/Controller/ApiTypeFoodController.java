package com.restaurant.c1603g.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.restaurant.c1603g.Entity.EntityService;
import com.restaurant.c1603g.Entity.TypeFood;
import com.restaurant.c1603g.Service.OtherService;
import com.restaurant.c1603g.Service.TypeFoodService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ApiTypeFoodController {

	@Autowired
	OtherService otherService;

	@Autowired
	TypeFoodService typeFoodService;

	@RequestMapping("/get/food")
	public List<EntityService> getFoodService() {
		return null;
	}

	@RequestMapping("/search/typefood")
	public TypeFood searchFoodService(@RequestParam("Id") String id) {
		return typeFoodService.getTypeFood(id);
	}
	
	@RequestMapping(value = "/serchAll/TypeFood" , method = RequestMethod.GET)
	public List<TypeFood> getALlTypeFood(@RequestParam("name") String name){
		return typeFoodService.getAllFood(name);
	}

	@RequestMapping(value = "/insert/typefood", method = RequestMethod.POST)
	public String insertTypeFood(@RequestBody TypeFood typefood) {
		return typeFoodService.insertTypeFood(typefood);
	}

	@RequestMapping(value = "/update/typefood", method = RequestMethod.POST)
	public boolean updateTypeFood(@RequestBody TypeFood typefood) {
		return typeFoodService.updateTypeFood(typefood);
	}
	
	@RequestMapping(value = "/delete/typefood", method = RequestMethod.POST)
	public boolean deleteTypeFood(@RequestParam("id") String typefood) {
		return typeFoodService.deleteTypeFood(typefood);
	}
	

}














