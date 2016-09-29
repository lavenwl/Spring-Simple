package com.laven.aop;

import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
	static Properties props = new Properties();
	
	private PropertiesUtil(){}
	
	public static Properties getInstance(String path) throws IOException{
		props.load(PropertiesUtil.class.getClassLoader().getResourceAsStream(path));
		return props;
	}
	
	public static String getProperty(String key){
		String val="";
		if(props != null){
			String prop = props.getProperty(key);
			if(prop != null){
				val = prop;
			}
		}
		return val;
	}
}
