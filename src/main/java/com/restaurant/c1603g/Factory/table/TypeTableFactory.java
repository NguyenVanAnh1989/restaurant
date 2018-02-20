package com.restaurant.c1603g.Factory.table;

import java.util.List;

import com.restaurant.c1603g.DAO.CommonDAO;
import com.restaurant.c1603g.DAO.table.TypeTableDAO;
import com.restaurant.c1603g.Entity.other.DeclareId;
import com.restaurant.c1603g.Entity.table.TypeTable;
import com.restaurant.c1603g.Factory.InterfaceFactory.CrudEntity;

public class TypeTableFactory implements CrudEntity<TypeTable> {

	@Override
	public TypeTable getEntity(String id) {
		return new TypeTableDAO().getEntityById(id);
	}

	@Override
	public List<TypeTable> getManyEntityByName(String name) {
		return new TypeTableDAO().getManyEntityByName(name);
	}

	@Override
	public String insertEntity(TypeTable typeTable) {
		DeclareId declare = new CommonDAO().getIdOfEntity("TT");
		typeTable.setId(declare.toString());
		if(new TypeTableDAO().insertEntity(typeTable) != null) {
			new CommonDAO().updateIdOfEntity(declare.getNameId(),declare.getValue());
			return "Success Full Insert";
		}else {
			return "Not Success Full can be duplicate or Fail some thing";
		}
	}

	@Override
	public String updateEntity(TypeTable typeTable) {
		return new TypeTableDAO().updateEntity(typeTable);
	}

	@Override
	public String deleteEntity(String id) {
		return new TypeTableDAO().deleteEntity(id);
	}

}
