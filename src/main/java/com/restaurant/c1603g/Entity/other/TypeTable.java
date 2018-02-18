package com.restaurant.c1603g.Entity.other;

public class TypeTable {
	private String id;
	private String type_seat;
	private String type_room;
	private String description;
	private int activated;
	private double price;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType_seat() {
		return type_seat;
	}

	public void setType_seat(String type_seat) {
		this.type_seat = type_seat;
	}

	public String getType_room() {
		return type_room;
	}

	public void setType_room(String type_room) {
		this.type_room = type_room;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getActivated() {
		return activated;
	}

	public void setActivated(int activated) {
		this.activated = activated;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
