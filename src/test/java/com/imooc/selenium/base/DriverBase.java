package com.imooc.selenium.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DriverBase {
	
	public WebDriver driver;
	
	public DriverBase(String broswer) {
		SelectDriver select = new SelectDriver();
		this.driver = select.driverName(broswer); //则上面的public driver就被实例化得到了selectDriver里的driver,其他方法就可以直接使用DriverBase里的driver了
		
	}

	public void close() {
		driver.close();
		System.out.println("stop webdriver");
	}
	
	/**
	 *封装Element方法
	 * */
	public WebElement findElement(By by) {
		WebElement element = driver.findElement(by);
		return element;
	}
	
	/**
	 * 封装get方法
	 * */
	public void get(String url) {
		driver.get(url);
	}
	
	/**
	 * 封装返回back方法
	 * */
	public void back() {
		driver.navigate().back();
	}
	
	
	/**
	 * 封装窗口最大化方法 
	 * */
	public void maxWindow() {
		driver.manage().window().maximize();
	}
	
	/**
	 * 封装click方法
	 * */
//	public void click(By by) {
//		driver.findElement(by).click();
//	}
	public void click(WebElement element) {
		element.click();
	}
	
	/**
	 * 封装getText()方法
	 * */
	public String getText(WebElement element) {
		return element.getText();
	}
}
