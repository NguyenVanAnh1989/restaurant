package com.restaurant.c1603g.Controller.other;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.restaurant.c1603g.Service.ImageService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ImageController {

	@Autowired
	ImageService imageService;

	@GetMapping("/image/{folder}/{image}")
	public byte[] getImage(@PathVariable("folder") String folder,@PathVariable("image") String image) {
		return imageService.getImage(folder,image);
	}

	@PostMapping("/create/image/{folder}")
	public String insertImage(@RequestParam("imageUpload") MultipartFile multipartFile,
			@PathVariable("folder") String folder) {
		return imageService.insertService(multipartFile, folder);
	}

}
