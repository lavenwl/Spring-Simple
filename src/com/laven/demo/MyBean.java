package com.laven.demo;

public class MyBean {
	public MyBean(){
		System.out.println("创建了MYBEAN对象");
	}
	
	public void myinit(){
		System.out.println("执行了MYbean对象的初始化方法！");
	}
	
	public void mydestroy(){
		System.out.println("执行了MyBean对象的销毁方法，释放资源");
	}
}
