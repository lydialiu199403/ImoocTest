package com.imooc.selenium.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ProUtil {
	private Properties pro;
	private String filepath;
	
	/**
	 * 构造函数
	 * @throws IOException 
	 * */
	public ProUtil(String filepath) throws IOException{
		this.filepath = filepath;
		this.pro = readProperties();
	}
	
	/**
	 * 读取配置文件
	 * @throws IOException 
	 * */
	private Properties readProperties() throws IOException {
		Properties prop = new Properties();
		InputStream in = new BufferedInputStream(new FileInputStream(filepath));
		prop.load(in);
		return prop;
	}
	
	public String getPro(String key) throws IOException {	

		String username = pro.getProperty(key);
		return username;
	}

	

}
