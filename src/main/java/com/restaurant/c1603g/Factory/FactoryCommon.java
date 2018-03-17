package com.restaurant.c1603g.Factory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FactoryCommon {

	public String convertDateToString(Date date) {

		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = simple.format(date);
		return dateString;

	}

	public boolean checkDateValid(String dateTime) {
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date;
		try {
			date = simple.parse(dateTime);
			if (date.getTime() < System.currentTimeMillis()) {
				return false;
			} else {
				return true;
			}
		} catch (ParseException e) {
			return false;
		}

	}

}
