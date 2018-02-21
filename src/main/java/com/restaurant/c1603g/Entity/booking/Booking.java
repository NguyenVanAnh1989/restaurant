package com.restaurant.c1603g.Entity.booking;

public class Booking {

	private String id;
	private String customer_Name;
	private String customer_Phone;
	private String customer_Mail;
	private int custommer_Number;
	private String table_Id;
	private String service_Id;
	private String reception_Id;
	private String date_Book_Start;
	private String date_Book_End;
	private double total;
	private String date_Pay;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCustomer_Name() {
		return customer_Name;
	}

	public void setCustomer_Name(String customer_Name) {
		this.customer_Name = customer_Name;
	}

	public String getCustomer_Phone() {
		return customer_Phone;
	}

	public void setCustomer_Phone(String customer_Phone) {
		this.customer_Phone = customer_Phone;
	}

	public String getCustomer_Mail() {
		return customer_Mail;
	}

	public void setCustomer_Mail(String customer_Mail) {
		this.customer_Mail = customer_Mail;
	}

	public int getCustommer_Number() {
		return custommer_Number;
	}

	public void setCustommer_Number(int custommer_Number) {
		this.custommer_Number = custommer_Number;
	}

	public String getTable_Id() {
		return table_Id;
	}

	public void setTable_Id(String table_Id) {
		this.table_Id = table_Id;
	}

	public String getService_Id() {
		return service_Id;
	}

	public void setService_Id(String service_Id) {
		this.service_Id = service_Id;
	}

	public String getReception_Id() {
		return reception_Id;
	}

	public void setReception_Id(String reception_Id) {
		this.reception_Id = reception_Id;
	}

	public String getDate_Book_Start() {
		return date_Book_Start;
	}

	public void setDate_Book_Start(String date_Book_Start) {
		this.date_Book_Start = date_Book_Start;
	}

	public String getDate_Book_End() {
		return date_Book_End;
	}

	public void setDate_Book_End(String date_Book_End) {
		this.date_Book_End = date_Book_End;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getDate_Pay() {
		return date_Pay;
	}

	public void setDate_Pay(String date_Pay) {
		this.date_Pay = date_Pay;
	}

}
