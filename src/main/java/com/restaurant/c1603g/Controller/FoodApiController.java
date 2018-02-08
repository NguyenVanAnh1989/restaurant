package com.restaurant.c1603g.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.restaurant.c1603g.Entity.food.Food;
import com.restaurant.c1603g.Service.FoodService;

@RestController
@RequestMapping("/api")
public class FoodApiController {

	@Autowired
	FoodService foodService;

	@GetMapping("/get/food")
	public Food getFood(@RequestParam("Id") String id) {
		return foodService.getFoodById(id);
	}

	@GetMapping("/get/foods")
	public List<Food> getAllFood(@RequestParam("name") String name) {
		return foodService.getAllFoodByName(name);
	}

	@PostMapping("/insert/food")
	public String insertFood(@RequestBody Food food) {
		return foodService.insertFood(food);
	}

	@PostMapping("/update/food")
	public String updateFood(@RequestBody Food food) {
		return foodService.updateFood(food);
	}

	@PostMapping("/delete/food")
	public String deleteFood(@RequestParam("Id") String id) {
		return foodService.deleteFood(id);
	}

}
