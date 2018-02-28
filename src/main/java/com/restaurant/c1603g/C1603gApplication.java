package com.restaurant.c1603g;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.restaurant.c1603g.Entity.manage.Addmin;

@SpringBootApplication
@ComponentScan(basePackages = { "com.restaurant.c1603g.Controller", "com.restaurant.c1603g.Service", "" })
public class C1603gApplication {
	public static void main(String[] args)
			throws ClassNotFoundException, IllegalAccessException, InvocationTargetException {
		 SpringApplication.run(C1603gApplication.class, args);
		// System.out.println(new FactoryCommon().convertDateToString(new Date()));
//		String id="id";
//		String name = "name";
//		String pass = "pass";
//		String per =  "per";
//		int h = 1;
//		Addmin addmin = new Addmin();
//
//		Class<? extends Addmin> clAdmin = addmin.getClass();
//		Method[] method = clAdmin.getDeclaredMethods();
//		for (Method mth : method) {
//			if (mth.getName().substring(0, 3).equals("set")) {
//				try {
//					Parameter[] param = mth.getParameters();
//					for (Parameter pr : param) {
//						if(pr.getType().equals(Integer.class)) {
//							System.out.println("Integer");
//						}else if (pr.getType().equals(String.class)) {
//							System.out.println("String");
//						}else if(pr.getType().equals(int.class)) {
//							System.out.println("int");
//						}
//					}
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//
//		}

	}
}
