package com.restaurant.c1603g;

import java.lang.reflect.InvocationTargetException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.restaurant.c1603g.Factory.booking.SupportBookingFactory;

@SpringBootApplication
@ComponentScan(basePackages = { "com.restaurant.c1603g.Controller", "com.restaurant.c1603g.Service", "" })
public class C1603gApplication {
	public static void main(String[] args)
			throws ClassNotFoundException, IllegalAccessException, InvocationTargetException {
		 //SpringApplication.run(C1603gApplication.class, args);
		 //new SupportBookingFactory().checkTableByTypeSeat("10");
		new SupportBookingFactory().getIdTableInBooking("4");

	}
}
