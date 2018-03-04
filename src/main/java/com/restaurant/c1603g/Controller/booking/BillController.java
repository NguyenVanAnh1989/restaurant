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

import com.restaurant.c1603g.Entity.booking.Bill;
import com.restaurant.c1603g.Service.booking.BillService;


@RestController
@CrossOrigin
@RequestMapping("/api")
public class BillController {
	
	@Autowired
	BillService billService;

	@GetMapping("/get/bill")
	public Bill getBill(@RequestParam("Id") String id) {
		return billService.getBillById(id);
	}

	@GetMapping("/get/bills")
	public List<Bill> getManyBillByIdBooking(@RequestParam("Id") String id) {
		return billService.getManyBillByIdBooking(id);
	}

	@PostMapping("/insert/bill")
	public String insertBill(@RequestBody Bill bill) {
		return billService.insertBill(bill);
	}

	@PostMapping("/update/bill")
	public String updategetBill(@RequestBody Bill bill) {
		return billService.updateBill(bill);
	}

	@PostMapping("/delete/bill")
	public String deleteBill(@RequestParam("Id") String id) {
		return billService.deleteBill(id);
	}

}
