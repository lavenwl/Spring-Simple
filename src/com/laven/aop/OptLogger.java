package com.laven.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;

public class OptLogger {
	Logger logger = Logger.getLogger(OptLogger.class);
	public void logger(){
		System.out.println("记录了操作日志");
	}
	public Object logger2(ProceedingJoinPoint pjp) throws Throwable{
		//proceed()方法有执行目标对象的功能
		Object obj = pjp.proceed();
		
		//获取方法名
		String methodName = pjp.getSignature().getName();
		//获取目标对象类名
		String clazzName = pjp.getTarget().getClass().getName();
		
		PropertiesUtil.getInstance("com/laven/aop/opt.properties");
		String key = clazzName + "." + methodName;
		
		System.out.println("执行了" + clazzName + "的" +methodName + "方法");
		System.out.println("执行了" + PropertiesUtil.getProperty(key));
		return obj;
	}
	
	public void mybefore(){
		System.out.println("--前置通知--");
	}
	
	public void myafterReturning(Object retVal){
		System.out.println("--后置通知--" + retVal);
	}
	
	public void myafterException(Exception e){
		System.out.println("异常捕获开始--");
//		e.printStackTrace();
		StringBuffer sb = new StringBuffer();
		sb.append("=========================\n");
		StackTraceElement[] element = e.getStackTrace();
		
		for(StackTraceElement ele:element){
			sb.append(ele + "\n");
		}
		logger.error(e);
		logger.error(sb.toString());
		System.out.println("异常捕获结束--");
	}
	
	public void myafter(){
		System.out.println("最终通知--");
	}
}
