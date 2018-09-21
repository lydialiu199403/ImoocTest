package com.imooc.selenium.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelectDriver {

	public WebDriver driverName(String broswer) {
		if(broswer.equals("chrome")) {
			System.setProperty("webdriver.chrome.marionette", "E:\\dependency pac\\chromedriver.exe");
			return new ChromeDriver();
		}else {
			System.setProperty("webdriver.fireFox.marionette", "E:\\dependency pac\\geckodriver.exe");
			return new FirefoxDriver();
		}
		
	}
}
