package com.restaurant.c1603g.Service;

import org.springframework.stereotype.Service;

import com.restaurant.c1603g.Entity.other.EntityService;

@Service
public class OtherService {
	
	public EntityService getBill() {
		EntityService en = new EntityService();
		en.setId("Done");
		en.setName("Ok men");
		en.setImage("adsfasdfasdf");
		en.setDiscount(10);
		en.setDescription("Ngon");
		return en;
	}
	
}
