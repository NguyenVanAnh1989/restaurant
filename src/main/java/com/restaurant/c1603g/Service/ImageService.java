package com.restaurant.c1603g.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.restaurant.c1603g.Factory.image.ImageFactory;

@Service
public class ImageService {
	public String insertService(MultipartFile multipartFile,String folder) {
		return new ImageFactory().insertImage(multipartFile,folder);
	}

	public byte[] getImage(String folder,String image) {
		return new ImageFactory().getImage(folder,image);
	}
}
