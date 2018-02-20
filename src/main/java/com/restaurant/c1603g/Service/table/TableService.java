package com.restaurant.c1603g.Service.table;

import java.util.List;

import org.springframework.stereotype.Service;

import com.restaurant.c1603g.Entity.table.Table;
import com.restaurant.c1603g.Factory.table.TableFactory;


@Service
public class TableService {

	public Table getTable(String id) {
		return new TableFactory().getEntity(id);
	}

	public List<Table> getTablesByTypeSeat(String typeseat) {
		return new TableFactory().getManyEntityByName(typeseat);
	}

	public String insertTable(Table table) {
		return new TableFactory().insertEntity(table);
	}

	public String updateTable(Table table) {
		return new TableFactory().updateEntity(table);
	}

	public String deleteTable(String id) {
		return new TableFactory().deleteEntity(id);
	}

}
