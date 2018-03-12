package com.restaurant.c1603g.Entity.table;

public class Table {

	private String id;
	private String name;
	private String type_table_id;
	private int activated;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType_table_id() {
		return type_table_id;
	}

	public void setType_table_id(String type_table_id) {
		this.type_table_id = type_table_id;
	}

	public int getActivated() {
		return activated;
	}

	public void setActivated(int activated) {
		this.activated = activated;
	}

}
