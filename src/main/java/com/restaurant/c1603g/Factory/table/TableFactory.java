package com.restaurant.c1603g.Factory.table;

import java.util.List;

import com.restaurant.c1603g.Constant.LogInfo;
import com.restaurant.c1603g.DAO.CommonDAO;
import com.restaurant.c1603g.DAO.table.TableDAO;
import com.restaurant.c1603g.Entity.other.DeclareId;
import com.restaurant.c1603g.Entity.table.Table;
import com.restaurant.c1603g.Factory.InterfaceFactory.CrudEntity;

public class TableFactory implements CrudEntity<Table>{

	@Override
	public Table getEntity(String id) {
		return new TableDAO().getEntityById(id);
	}

	@Override
	public List<Table> getManyEntityByName(String typeSeat) {
		return new TableDAO().getManyEntityByName(typeSeat);
	}

	@Override
	public String insertEntity(Table table) {
		DeclareId declare = new CommonDAO().getIdOfEntity("TB");
		table.setId(declare.toString());
		String info = new TableDAO().insertEntity(table);
		if(info.equals(LogInfo.SUCCESS_FULL)) {
			new CommonDAO().updateIdOfEntity(declare.getNameId(),declare.getValue());
			return info;
		}else {
			return info;
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
