package com.restaurant.c1603g.DAO.Responsibility;

import java.util.List;

public interface DAOResponsibility<E> {
	
	E getEntityById(String id);
	List<E> getALlEntityByName(String name);
	String updateEntity(E e);
	String deleteEntity(String id);
	String insertEntity(E e);
		
}
