package com.restaurant.c1603g.Entity;

import java.util.Date;

public class Booking {

	private String id;
	private String customerName;
	private String customerPhone;
	private String customerMail;
	private int quantityCustommer;
	private Date dateBook;
	private double total;
	private String tableId;
	private String receptionId;
	private String serviceId;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	public String getCustomerMail() {
		return customerMail;
	}
	public void setCustomerMail(String customerMail) {
		this.customerMail = customerMail;
	}
	public int getQuantityCustommer() {
		return quantityCustommer;
	}
	public void setQuantityCustommer(int quantityCustommer) {
		this.quantityCustommer = quantityCustommer;
	}
	public Date getDateBook() {
		return dateBook;
	}
	public void setDateBook(Date dateBook) {
		this.dateBook = dateBook;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getTableId() {
		return tableId;
	}
	public void setTableId(String tableId) {
		this.tableId = tableId;
	}
	public String getReceptionId() {
		return receptionId;
	}
	public void setReceptionId(String receptionId) {
		this.receptionId = receptionId;
	}
	public String getServiceId() {
		return serviceId;
	}
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	
	
	
	
	
}
