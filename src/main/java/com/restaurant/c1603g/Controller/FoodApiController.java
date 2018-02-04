package com.restaurant.c1603g.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.c1603g.Service.FoodService;

@RestController
@RequestMapping("/api")
public class FoodApiController {
		
	@Autowired 
	FoodService foodService;
	
	@GetMapping("/get/foods")
	public String getAllFood() {
		return foodService.getAllFood();
	}
	
}
