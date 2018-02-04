package com.restaurant.c1603g;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.restaurant.c1603g.Controller","com.restaurant.c1603g.Service",""})
public class C1603gApplication {

	public static void main(String[] args) {
		SpringApplication.run(C1603gApplication.class, args);
	}
}
