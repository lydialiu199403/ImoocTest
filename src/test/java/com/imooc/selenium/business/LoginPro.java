package com.imooc.selenium.business;

import java.io.IOException;

import com.imooc.selenium.base.DriverBase;
import com.imooc.selenium.handle.loginPageHandle;

public class LoginPro {

	public DriverBase driver;
	public loginPageHandle lph;
	public LoginPro(DriverBase driver) {
		this.driver = driver;
		lph = new loginPageHandle(driver);		
	}
	
	/**
	 * 执行登录操作
	 * @throws IOException 
	 * */
	public void login(String username,String password) throws IOException {
		if(lph.assertLoginPage()) {
			lph.sendKeysUsername(username);
			lph.sendKeysPassword(password);
			lph.clickAutoSignin();
			lph.clickLoginButton();
		}
		else {
			System.out.println("页面不存在或者状态不正确，无法登录");
		}
	}
}
