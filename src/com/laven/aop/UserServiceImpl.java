package com.laven.aop;

public class UserServiceImpl implements UserService{

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("更新数据");
		String s = null;
		s.length();
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		System.out.println("删除数据");
	}

	@Override
	public boolean save() {
		// TODO Auto-generated method stub
		System.out.println("保存数据");
		return true;
	}

}
