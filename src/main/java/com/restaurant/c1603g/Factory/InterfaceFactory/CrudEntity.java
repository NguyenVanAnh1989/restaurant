package com.restaurant.c1603g.Factory.InterfaceFactory;

import java.util.List;

public interface CrudEntity<E> {
	
	E getFood(String id);
	List<E> getAllFood(String name);
	boolean insertEntity(E e);
	boolean updateEntity(E e);
	boolean deleteEntity(String id);
	
}
