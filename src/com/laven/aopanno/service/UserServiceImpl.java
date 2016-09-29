package com.laven.aopanno.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.laven.aopanno.dao.UserDao;

@Service("userService")
public class UserServiceImpl implements UserService{

	private UserDao userDao;
	@Resource(name="jdbcUserDao")
	public void setUserDao(UserDao userDao){
		this.userDao = userDao;
	}
	
	@Override
	public void regist() {
		// TODO Auto-generated method stub
		System.out.println("service:用户注册处理");
		userDao.save(null);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("service:用户修改个人信息处理");
		userDao.update(null);
	}

}
