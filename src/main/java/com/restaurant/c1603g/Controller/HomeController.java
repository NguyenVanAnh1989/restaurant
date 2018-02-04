package com.restaurant.c1603g.Controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/home")
public class HomeController {

	@RequestMapping("/")
	public ModelAndView homeView() {
		return new ModelAndView("namePage");
	}
		
	
}
