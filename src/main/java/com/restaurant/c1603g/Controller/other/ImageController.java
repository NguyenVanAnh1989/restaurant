package com.restaurant.c1603g.Controller.other;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.c1603g.Service.ImageService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ImageController {
	
	@Autowired
	ImageService imageService;
	
	
	@GetMapping("/image/{url}")
	public byte[] getImage(@PathVariable("url") String url) {
		File file = new File("D:/image/"+url+".jpg");
		byte[] b = new byte[2048];
		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream(file);
			fileInputStream.read(b);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return b;
	}
	
	@PostMapping("/insert/image/{folder}")
	public String insertImage() {
		return null;
	}
	
	
}
