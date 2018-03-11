package com.restaurant.c1603g.Controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@CrossOrigin
@RequestMapping("/home")
public class HomeController {

	@RequestMapping("/")
	public ModelAndView homeView() {
		return new ModelAndView("namePage");
	}
		
	@RequestMapping("/test")
	public String getName() {
		return "ok";
	}
	@GetMapping("callimage")
	public String insertImage() {
		return "sucess";
	}
	
	
}
