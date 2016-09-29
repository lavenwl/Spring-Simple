package com.laven.action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.laven.aop.UserService;
import com.laven.demo.CollectionBean;
import com.laven.demo.MyBean;

public class Test {
	private BaseAction action;
	public static void main(String[] args) {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		Test test = (Test)ac.getBean("test");
		test.action.execute();
		MyBean bean1 = (MyBean) ac.getBean("mybean");
		MyBean bean2 = (MyBean) ac.getBean("mybean");
		System.out.println(bean1 ==bean2);
		
		CollectionBean bean = (CollectionBean) ac.getBean("collectionbean");
		bean.show();
		
		UserService service = (UserService) ac.getBean("userService");
		service.delete();
		service.save();
		service.update();
		
		ac.close();
	}
	public void setAction(BaseAction action) {
		this.action = action;
	}
	
}
