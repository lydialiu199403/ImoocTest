package com.imooc.selenium.business;

import java.io.IOException;

import com.imooc.selenium.base.DriverBase;
import com.imooc.selenium.handle.SubmitOrderPageHandle;

public class SubmitOrderPagePro {
	
	public DriverBase driver;
	public SubmitOrderPageHandle submitOrderPageHandle;
	public SubmitOrderPagePro(DriverBase driver) {
		this.driver = driver;
		submitOrderPageHandle = new SubmitOrderPageHandle(driver);
	}
	
	/**
	 * 执行提交订单操作
	 * @throws IOException 
	 * */
	public void submitOrder() throws IOException {
		submitOrderPageHandle.clickSubmitOrderElement();
	}

}
