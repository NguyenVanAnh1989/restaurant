package com.restaurant.c1603g.Factory.booking;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.restaurant.c1603g.DAO.booking.SupportBookingDAO;

public class SupportBookingFactory {
	
	Map<String,List<Date>> listTable = new HashMap<>(); 
	
	public String checkTableByTypeSeat(String typeSeat) {
		List<String> listIdTable = new SupportBookingDAO().getIdTableByType(typeSeat);
		for(String id : listIdTable) {
			listTable.put(id, new ArrayList<>());
		}
		for (Map.Entry<String,List<Date>> entry : listTable.entrySet()) {
			System.out.println(entry.getKey());
		}
		return null;
	}
		
	public Map<String,List<String>> getIdTableInBooking(String typeSeat) {
		Map<String,List<String>> mapTableBooking = new SupportBookingDAO().getIdTableInBooking(typeSeat);
		for (Map.Entry<String,List<String>> entry : mapTableBooking.entrySet()) {
			System.out.println(entry.getKey());
			for(String time : entry.getValue()) {
				System.out.println(time);
			}
		}
		return mapTableBooking;
	}
	
	
}
