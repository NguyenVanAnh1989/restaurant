package com.restaurant.c1603g.Entity.other;

public class DeclareId {

	private String nameId;
	private int value;

	public String getNameId() {
		return nameId;
	}

	public void setNameId(String nameId) {
		this.nameId = nameId;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		String start = "000000";
		String idEntity = (value > 999999) ? (nameId + value)
				: (nameId + start.substring(0, start.length() - ("" + value).length())) + value;
		return idEntity;
	}

}
