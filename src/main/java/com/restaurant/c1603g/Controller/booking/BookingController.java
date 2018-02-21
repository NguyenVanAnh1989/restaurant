package com.restaurant.c1603g.Controller.booking;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.c1603g.Entity.booking.Booking;
import com.restaurant.c1603g.Service.booking.BookingService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class BookingController {
	
	@Autowired
	BookingService bookingService;
	
	@GetMapping("/get/booking")
	public Booking getBooking(@RequestParam("Id") String id ) {
		return bookingService.getBooking(id);
	}
	
	@GetMapping("/get/bookings")
	public List<Booking> getManyBookingByName(@RequestParam("name") String name) {
		return bookingService.getManyBookingByName(name);
	}
	
	@PostMapping("/insert/booking")
	public String insertBooking(@RequestBody Booking booking) {
		return bookingService.insertBooking(booking);
	}
	@PostMapping("/update/booking")
	public String updategetBooking(@RequestBody Booking booking) {
		return bookingService.updateBooking(booking);
	}
	
	@PostMapping("/delete/booking")
	public String deleteBooking(@RequestParam("Id") String id) {
		return bookingService.deleteBooking(id);
	}
}
