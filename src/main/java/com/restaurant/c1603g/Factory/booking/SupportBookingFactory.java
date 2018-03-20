package com.restaurant.c1603g.Factory.booking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.restaurant.c1603g.DAO.booking.SupportBookingDAO;
import com.restaurant.c1603g.Entity.table.Table;

public class SupportBookingFactory {

	public List<Table> getListTableAvailable(String dateTime) {
		List<Table> listTableAvailable = new ArrayList<>();
		for (Table tbl : getAllTableStatusForBooking(dateTime)) {
			if (tbl.getActivated() == 1) {
				listTableAvailable.add(tbl);
			}
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
