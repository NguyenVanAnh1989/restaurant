package com.restaurant.c1603g.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.c1603g.Entity.Booking;
import com.restaurant.c1603g.Entity.EntityService;
import com.restaurant.c1603g.Entity.Table;
import com.restaurant.c1603g.Entity.TypeFood;
import com.restaurant.c1603g.Service.FoodService;
import com.restaurant.c1603g.Service.OtherService;

@RestController
@RequestMapping("/api")
public class ApiController {
	
	@Autowired
	OtherService otherService;
	
	@Autowired
	FoodService foodService;
	
	@RequestMapping("/get/food")
	public List<EntityService> getFoodService() {
		return null;
	}
	
	@CrossOrigin
	@RequestMapping("/search/food")
	public EntityService searchFoodService() {
		System.out.println("Done");
		return otherService.getBill();
	}
	
	@CrossOrigin
	@RequestMapping(value="/insert/food" , method= RequestMethod.POST)
	public String insertTypeFood(@RequestBody TypeFood food) {
		return foodService.insertTypeFood(food);	
	}
	
	@RequestMapping("/check/table/{param}")
	public List<Table> checkTableService() {
		return null;
	}
	

	@RequestMapping("/get/booking/{param}")
	public Booking getBookingService() {
		return null;
	}
	static class User{
		String name;
		String phone;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		
	}
	
}















