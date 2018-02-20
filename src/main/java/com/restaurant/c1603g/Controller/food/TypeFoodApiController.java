package com.restaurant.c1603g.Controller.food;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.restaurant.c1603g.Entity.food.TypeFood;
import com.restaurant.c1603g.Service.food.TypeFoodService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class TypeFoodApiController {

	@Autowired
	TypeFoodService typeFoodService;

	@RequestMapping("/get/typefood")
	public TypeFood searchFoodService(@RequestParam("Id") String id) {
		return typeFoodService.getTypeFood(id);
	}
	
	@RequestMapping(value = "/get/typefoods" , method = RequestMethod.GET)
	public List<TypeFood> getTypeFoodByName(@RequestParam("name") String name){
		return typeFoodService.getTypeFoodByName(name);
	}

	@RequestMapping(value = "/insert/typefood", method = RequestMethod.POST)
	public String insertTypeFood(@RequestBody TypeFood typefood) {
		return typeFoodService.insertTypeFood(typefood);
	}

	@RequestMapping(value = "/update/typefood", method = RequestMethod.POST)
	public String updateTypeFood(@RequestBody TypeFood typefood) {
		return typeFoodService.updateTypeFood(typefood);
	}
	
	@RequestMapping(value = "/delete/typefood", method = RequestMethod.POST)
	public String deleteTypeFood(@RequestParam("Id") String typefood) {
		return typeFoodService.deleteTypeFood(typefood);
	}
	

}














