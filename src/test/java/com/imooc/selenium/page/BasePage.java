package com.imooc.selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.imooc.selenium.base.DriverBase;

public class BasePage {
	public DriverBase driver;
	public BasePage(DriverBase driver) {
		this.driver = driver;
	}
	
	
	/**
	 * 定位Element方法
	 * */
	public WebElement element(By by) {
		WebElement element = driver.findElement(by);
		return element;
	}
	
	/**
	 * 通过父节点获取子节点方法
	 * */
	public WebElement nodeElement(By by,By nodeBy) {
		WebElement element = this.element(by);
		return element.findElement(nodeBy);
	}
	
	/**
	 * 封装点击方法click
	 * */
	public void click(WebElement element) {
		if(element != null) {
			element.click();
		}else {
			System.out.println("元素没有定位到，点击失败");
		}
	}
	
	/**
	 * 封装输入方法sendkeys
	 * */
	public void sendKeys(WebElement element,String value) {
		if(element != null) {
			element.sendKeys(value);
		}else {
			System.out.println(element+"元素没有定位到，输入失败"+value);
		}	
	}
	
	/**
	 * 判断元素是否显示
	 * */
	public boolean assertElementIs(WebElement element) {
		return element.isDisplayed();
	}
	
	
	
	
}
