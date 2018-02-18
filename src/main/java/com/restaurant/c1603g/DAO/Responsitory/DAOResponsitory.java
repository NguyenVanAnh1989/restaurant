package com.restaurant.c1603g.DAO.Responsitory;

import java.util.List;

public interface DAOResponsitory<E> {
	
	E getEntityById(String id);
	List<E> getManyEntityByName(String name);
	String insertEntity(E e);
	String updateEntity(E e);
	String deleteEntity(String id);
	
		
}
