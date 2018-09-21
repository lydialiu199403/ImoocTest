package com.imooc.selenium.handle;

import java.io.IOException;

import com.imooc.selenium.base.DriverBase;
import com.imooc.selenium.page.loginPage;

public class loginPageHandle {
	
	public DriverBase driver;
	public loginPage lp;
	public loginPageHandle(DriverBase driver) {
		this.driver = driver;
		lp = new loginPage(driver);
	}
	
	/**
	 * 输入登录用户名
	 * @throws IOException 
	 * */
	public void sendKeysUsername(String username) throws IOException {
		lp.sendKeys(lp.getUserElement(), username);
		//driver.findElement(By.id()).
	}
	
	/**
	 * 输入登录密码
	 * @throws IOException 
	 * */
	public void sendKeysPassword(String password) throws IOException {
		lp.sendKeys(lp.getPassElement(), password);
	}
	
	/**
	 * 点击登录按钮
	 * @throws IOException 
	 * */
	public void clickLoginButton() throws IOException {
		lp.click(lp.getLoginButtonElement());
	}
	
	/**
	 * 点击选中自动登录按钮
	 * @throws IOException 
	 * */
	public void clickAutoSignin() throws IOException {
		lp.click(lp.getAutoSigninElement());
	}
	
	/**
	 * 判断登录框是否存在
	 * @throws IOException 
	 * */
	public boolean assertLoginPage() throws IOException {
		return lp.assertElementIs(lp.getUserElement());
	}
	
}
