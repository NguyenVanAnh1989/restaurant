package com.restaurant.c1603g.Service.booking;

import java.util.List;

import org.springframework.stereotype.Service;

import com.restaurant.c1603g.DAO.booking.SupportBookingDAO;
import com.restaurant.c1603g.Entity.booking.Booking;
import com.restaurant.c1603g.Entity.table.Table;
import com.restaurant.c1603g.Factory.booking.BookingFactory;
import com.restaurant.c1603g.Factory.booking.SupportBookingFactory;

@Service
public class BookingService {

	public Booking getBooking(String id) {
		return new BookingFactory().getEntity(id);
	}

	public List<Booking> getManyBookingByName(String name) {
		return new BookingFactory().getManyEntityByName(name);
	}

	public String insertBooking(Booking booking) {
		return new BookingFactory().insertEntity(booking);
	}

	public String updateBooking(Booking booking) {
		return new BookingFactory().updateEntity(booking);
	}

	public List<Table> getListTableForBooking(String dateTime){
		return new SupportBookingFactory().getlistTableAvailable(dateTime);
	}
	
	public String deleteBooking(String id) {
		return "Not allow Because now is not have";
	}

	
}
