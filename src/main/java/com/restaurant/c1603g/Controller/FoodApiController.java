package com.restaurant.c1603g.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.c1603g.Entity.Food;
import com.restaurant.c1603g.Service.FoodService;

@RestController
@RequestMapping("/api")
public class FoodApiController {
		
	@Autowired 
	FoodService foodService;
	
	@GetMapping("/get/foods")
	public List<Food> getAllFood(@RequestParam("name") String name) {
		return foodService.getAllFood();
	}
	
	@GetMapping("/get/food")
	public Food getFood() {
		return foodService.getFood();
	}
	
}
