package com.restaurant.c1603g.Factory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FactoryCommon {
	
	
	public String convertDateToString(Date date) {
		
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = simple.format(date);
		return dateString;
		
	}
	
	
	
}














