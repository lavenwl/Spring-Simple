package com.laven.aopanno.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.laven.aopanno.service.UserService;

public class Test1 {
	public static void main(String[] args){
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/laven/aopanno/schema.xml");
		UserService userService = (UserService) ac.getBean("userService");
		userService.regist();
		userService.update();
	}
}
