package com.restaurant.c1603g.Factory.InterfaceFactory;

import java.util.List;

public interface CrudEntity<E> {

	E getEntity(String id);
	List<E> getManyEntityByName(String name);
	String insertEntity(E e);
	String updateEntity(E e);
	String deleteEntity(String id);
	
}
