package com.restaurant.c1603g.Service;

import org.springframework.stereotype.Service;
import com.restaurant.c1603g.Entity.TypeFood;
import com.restaurant.c1603g.Factory.TypeFoodFactory;

@Service
public class FoodService {

	public String getAllFood() {
		return null;
	}

	public String insertTypeFood(TypeFood food) {
		if (new TypeFoodFactory().insertEntity(food)) {
			return "Successfull";
		} else
			return "not success";
	}

}
