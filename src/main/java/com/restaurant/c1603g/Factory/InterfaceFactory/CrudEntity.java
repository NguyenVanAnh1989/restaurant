package com.restaurant.c1603g.Factory.InterfaceFactory;

import java.util.List;

public interface CrudEntity<E> {
	
	E getFood();
	List<E> getAllFood();
	boolean insertEntity(E t);
	boolean updateEntity(E t);
	boolean deleteEntity(String id);
	
}
