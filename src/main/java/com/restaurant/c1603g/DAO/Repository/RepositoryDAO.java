package com.restaurant.c1603g.DAO.Repository;

import java.util.List;

public interface RepositoryDAO<E> {
	
	E getEntityById(String id);
	List<E> getManyEntityByName(String name);
	String insertEntity(E e);
	String updateEntity(E e);
	String deleteEntity(String id);
	
		
}
