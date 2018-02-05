package com.restaurant.c1603g.Service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.restaurant.c1603g.Entity.TypeFood;
import com.restaurant.c1603g.Factory.TypeFoodFactory;

@Service
public class TypeFoodService {

	public List<TypeFood> getAllFood(String name) {
		return new TypeFoodFactory().getAllFood(name);
	}

	public TypeFood getTypeFood(String id) {
		return new TypeFoodFactory().getFood(id);
	}

	public String insertTypeFood(TypeFood typefood) {
		if (new TypeFoodFactory().insertEntity(typefood)) {
			return "Successfull";
		} else
			return "not success";
	}

	public boolean updateTypeFood(TypeFood typefood) {
		return new TypeFoodFactory().updateEntity(typefood);
	}

	public boolean deleteTypeFood(String id) {
		return new TypeFoodFactory().deleteEntity(id);
	}

}
