package com.restaurant.c1603g.Factory.image;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.web.multipart.MultipartFile;

import com.restaurant.c1603g.Constant.LogInfo;

public class ImageFactory {

	public String insertImage(MultipartFile multipartFile,String folder) {
		if (multipartFile.isEmpty()) {
			return "Not good";
		} else {
			try {
				byte[] fByte = multipartFile.getBytes();
				Path path = Paths.get("D:/image/" + folder + "/" + multipartFile.getOriginalFilename());
				Files.write(path, fByte);
			} catch (IOException e) {
				return e.getMessage();
			}
		}
		return LogInfo.SUCCESS_FULL;
	}

	public byte[] getImage(String folder,String image) {
		File file = new File("D:/image/" + folder + "/" + image+ ".jpg");
		File file1 = new File("D:/image/" + folder +"/"+image + ".png");
		File file2 = new File("D:/image/" + folder +"/"+image + ".gif");
		if (!file.exists()) {
			file = file1;
			if (!file.exists()) {
				file = file2;
			}
		}
		byte[] b = new byte[(int) file.length()];
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

}
