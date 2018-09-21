package com.imooc.selenium.util;




import java.io.IOException;

import org.openqa.selenium.By;


public class getByLocator {
	
	public static By getLocator(String key) throws IOException{
		ProUtil proUtil = new ProUtil("element.properties");
		String locator = proUtil.getPro(key);
		String locatorType = locator.split(">")[0];
		String locatorValue = locator.split(">")[1];
		if(locatorType.equals("id")){
			return By.id(locatorValue);
		}else if(locatorType.equals("name")){
			return By.name(locatorValue);
		}else if(locatorType.equals("tagName")){
			return By.tagName(locatorValue);
		}else if(locatorType.equals("linkText")){
			return By.linkText(locatorValue);
		}else if(locatorType.equals("className")){
			return By.className(locatorValue);
		}else{
			return By.xpath(locatorValue);
		}
	}
}
