package com.imooc.selenium.handle;

import java.io.IOException;

import com.imooc.selenium.base.DriverBase;
import com.imooc.selenium.page.SubmitOrderPage;

public class SubmitOrderPageHandle {

	public DriverBase driver;
	public SubmitOrderPage submitOrderPage;
	public SubmitOrderPageHandle(DriverBase driver) {
		this.driver = driver;
		submitOrderPage = new SubmitOrderPage(driver);
	}
	
	/**
	 * 点击提交订单按钮操作
	 * @throws IOException 
	 * */
	public void clickSubmitOrderElement() throws IOException {
		driver.click(submitOrderPage.getSubmitOrderElement());
	}
}
