package com.restaurant.c1603g.Service.booking;

import java.util.List;

import org.springframework.stereotype.Service;

import com.restaurant.c1603g.Entity.booking.Bill;
import com.restaurant.c1603g.Entity.booking.Booking;
import com.restaurant.c1603g.Factory.booking.BillFactory;

@Service
public class BillService {

	public Booking getBillById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Booking> getManyBillByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public String insertBill(Bill bill) {
		return new BillFactory().insertEntity(bill);
	}

	public String updateBill(Bill bill) {
		// TODO Auto-generated method stub
		return null;
	}

	public String deleteBill(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
