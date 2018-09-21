package com.imooc.selenium.page;

import java.io.IOException;

import org.openqa.selenium.WebElement;

import com.imooc.selenium.base.DriverBase;
import com.imooc.selenium.util.getByLocator;

public class loginPage extends BasePage{
	
	public loginPage(DriverBase driver) {
		super(driver);
	}

	/**
	 * 获取登录用户名输入框element
	 * @throws IOException 
	 * */
	public WebElement getUserElement() throws IOException {
		return element(getByLocator.getLocator("username"));
		//element = driver.findElement(by);
	}
	
	/**
	 * 获取登录密码输入框element
	 * @throws IOException 
	 * */
	public WebElement getPassElement() throws IOException {
		return element(getByLocator.getLocator("userpass"));
	}
	
	/**
	 * 获取登录按钮element
	 * @throws IOException 
	 * */
	public WebElement getLoginButtonElement() throws IOException {
		return element(getByLocator.getLocator("loginButton"));
	}
	
	/**
	 * 获取自动登录勾选框element
	 * @throws IOException 
	 * */
	public WebElement getAutoSigninElement() throws IOException {
		return element(getByLocator.getLocator("autoSignin"));
	}

}
