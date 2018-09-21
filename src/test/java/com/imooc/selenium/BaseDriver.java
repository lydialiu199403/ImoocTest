package com.imooc.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class BaseDriver {
	public WebDriver driver;
	
	public WebDriver getDriver() {
		return driver;
	}
	
	@BeforeClass
	public void testbefore() {
		System.setProperty("webdriver.chrome.marionette", "E:\\dependency pac\\chromedriver.exe");
		driver = new ChromeDriver();
	}

}
