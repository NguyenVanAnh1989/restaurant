package com.restaurant.c1603g.Factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FactoryCommon {
	
	public boolean setIdForTypeFood(String fileName,byte[] b) {
		File file = new File(fileName);
		try {
			FileOutputStream fileOut = new FileOutputStream(file);
			fileOut.write(b);
			fileOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
			
	}
	
	public byte[] getDataInFile(String fileName) {
		
		File file = new File(fileName);
		byte[] byteText=new byte[20];
		try {
			FileInputStream fileIn = new FileInputStream(file);
			fileIn.read(byteText);
			fileIn.close();
			return byteText;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		return byteText;
	}
	
	//Increment Id for entity
	public String resolveTextAndInteger(String firstText,String number) {
		
		String Id = "";
		if(number.length()>6) {
			Id = firstText+number;	
			setIdForTypeFood("D:/Id.txt", number.getBytes());
		}else {
			try {
				int idNumber = Integer.parseInt(number);
				Id = ""+(idNumber+1);
				Id = firstText+"000000".substring(0,6-Id.length())+Id;
				setIdForTypeFood("D:/Id.txt", Id.substring(2).getBytes());
			}catch (Exception e) {
				e.getStackTrace();
			}
		}
		return Id;
		
	}
	
}














