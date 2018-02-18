package com.restaurant.c1603g.Service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.restaurant.c1603g.Entity.food.TypeFood;
import com.restaurant.c1603g.Factory.TypeFoodFactory;

@Service
public class TypeFoodService {

	public List<TypeFood> getAllFood(String name) {
		return new TypeFoodFactory().getAllEntity(name);
	}

	public TypeFood getTypeFood(String id) {
		return new TypeFoodFactory().getEntity(id);
	}

	public String insertTypeFood(TypeFood typefood) {
		if (new TypeFoodFactory().insertEntity(typefood) != null) {
			return "Successfull";
		} else
			return "not success";
	}

	public String updateTypeFood(TypeFood typefood) {
		return new TypeFoodFactory().updateEntity(typefood);
	}

	public String deleteTypeFood(String id) {
		return new TypeFoodFactory().deleteEntity(id);
	}

}
