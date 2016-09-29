package com.laven.aopanno.dao;

import java.util.List;

import com.laven.aopanno.entity.User;

public interface UserDao {
	public void save(User user);
	public void update(User user);
	public void deleteById(int id);
	 public User findById(int id);
	 public List<User> findAll();
	 public int count();
}
