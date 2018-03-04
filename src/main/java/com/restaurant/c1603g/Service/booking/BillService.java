package com.restaurant.c1603g.Service.booking;

import java.util.List;

import org.springframework.stereotype.Service;

import com.restaurant.c1603g.Entity.booking.Bill;
import com.restaurant.c1603g.Factory.booking.BillFactory;

@Service
public class BillService {

	public Bill getBillById(String id) {
		return new BillFactory().getEntity(id);
	}

	public List<Bill> getManyBillByIdBooking(String id) {
		return new BillFactory().getManyBillByIdBooking(id);
	}

	public String insertBill(Bill bill) {
		return new BillFactory().insertEntity(bill);
	}

	public String updateBill(Bill bill) {
		return new BillFactory().updateEntity(bill);
	}

	public String deleteBill(String id) {
		return new BillFactory().deleteEntity(id);
	}
	
	
	
}
