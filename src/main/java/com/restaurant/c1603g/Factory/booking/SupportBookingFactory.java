package com.restaurant.c1603g.Factory.booking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.restaurant.c1603g.DAO.booking.SupportBookingDAO;
import com.restaurant.c1603g.Entity.table.Table;

public class SupportBookingFactory {

	public List<Table> getlistTableAvailable(String dateTime) {
		Map<String, Table> mapTable = new HashMap<String, Table>();
		for (Table tbl : getAllTableStatusForBooking(dateTime)) {
			if (tbl.getActivated() == 1) {
				mapTable.put(tbl.getName(), tbl);
			}
		}
		List<Table> listTableAvailable = new ArrayList<>();
		for (Map.Entry<String, Table> _map : mapTable.entrySet()) {
			listTableAvailable.add(_map.getValue());
		}
		return listTableAvailable;
	}

	public List<Table> getAllTableStatusForBooking(String dateTime) {
		List<String> tableNotValid = getTableNotValid(dateTime);
		List<Table> listTableStatus = getAllTable();
		for (Table table : listTableStatus) {
			if (!tableNotValid.contains(table.getId())) {
				table.setActivated(2);
			}
		}
		return listTableStatus;

	}

	public List<String> getTableNotValid(String dateTime) {
		return new SupportBookingDAO().getIdTableInBooking(dateTime);
	}

	public List<Table> getAllTable() {
		List<Table> listIdTable = new SupportBookingDAO().getAllTable();
		return listIdTable;
	}

}
