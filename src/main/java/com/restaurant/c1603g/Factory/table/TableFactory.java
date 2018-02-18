package com.restaurant.c1603g.Factory.table;

import java.util.List;

import com.restaurant.c1603g.DAO.CommonDAO;
import com.restaurant.c1603g.DAO.table.TableDAO;
import com.restaurant.c1603g.Entity.other.DeclareId;
import com.restaurant.c1603g.Entity.other.Table;
import com.restaurant.c1603g.Factory.InterfaceFactory.CrudEntity;

public class TableFactory implements CrudEntity<Table>{

	@Override
	public Table getEntity(String id) {
		return new TableDAO().getEntityById(id);
	}

	@Override
	public List<Table> getAllEntity(String typeSeat) {
		return new TableDAO().getManyEntityByName(typeSeat);
	}

	@Override
	public String insertEntity(Table table) {
		DeclareId declare = new CommonDAO().getIdOfEntity("TB");
		table.setId(declare.toString());
		String info = new TableDAO().insertEntity(table);
		if(!info.equals("Exception") && info != null) {
			new CommonDAO().updateIdOfEntity(declare.getNameId(),declare.getValue());
			return "Successfull Done Ok";
		}else {
			return "Not Done Now Exception call";
		}		
	}

	@Override
	public String updateEntity(Table table) {
		return new TableDAO().updateEntity(table);
	}

	@Override
	public String deleteEntity(String id) {
		return new TableDAO().deleteEntity(id);
	}

}
