package com.laven.aopanno.test;


import junit.framework.Assert;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.laven.aopanno.dao.UserDao;
import com.laven.aopanno.entity.User;

public class TestUserDao {
	@Test
	public void testAdd(){
		User user = new User();
		user.setEmail("jdbc0@163.com"); 
		user.setNickname("jdbc"); 
		user.setPassword("1111"); 
		user.setUserIntegral(10); 
		user.setEmailVerify(false); 
		user.setEmailVerifyCode("asdfasdew"); 
		user.setLastLoginTime(System.currentTimeMillis()); 
		user.setLastLoginIp("192.168.2.1");
		ApplicationContext ac =new ClassPathXmlApplicationContext("com/laven/aopanno/schema.xml"); 
		UserDao userDao = (UserDao)ac.getBean("jdbcUserDao"); 
//		userDao.save(user);
		User user1 = userDao.findById(1); 
//		System.out.println(user1.getEmail());
		
		//采用junit断言方式判断字段是否正确
		Assert.assertEquals("jdbc@163.com", user1.getEmail());
		Assert.assertEquals("jdbc", user1.getNickname());
	}
	
	public static void main(String[] args){
		new TestUserDao().testAdd();
	}
}
