package com.restaurant.c1603g.Service.table;

import java.util.List;

import org.springframework.stereotype.Service;

import com.restaurant.c1603g.Entity.other.TypeTable;
import com.restaurant.c1603g.Factory.table.TypeTableFactory;

@Service
public class TypeTableService {

	public TypeTable getTypeTable(String id) {
		return new TypeTableFactory().getEntity(id);
	}

	public List<TypeTable> getTypeTablesByName(String name) {
		return new TypeTableFactory().getAllEntity(name);
	}

	public String insertTypeTable(TypeTable typeTable) {
		return new TypeTableFactory().insertEntity(typeTable);
	}

	public String updateTypeTable(TypeTable typeTable) {
		return new TypeTableFactory().updateEntity(typeTable);
	}

	public String deleteTypeTable(String id) {
		return new TypeTableFactory().deleteEntity(id);
	}
	
}
