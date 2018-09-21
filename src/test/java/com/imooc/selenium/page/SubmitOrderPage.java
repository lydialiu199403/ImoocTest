package com.imooc.selenium.page;

import java.io.IOException;

import org.openqa.selenium.WebElement;

import com.imooc.selenium.base.DriverBase;
import com.imooc.selenium.util.getByLocator;

public class SubmitOrderPage extends BasePage{

	public SubmitOrderPage(DriverBase driver) {
		super(driver);
	}

	/**
	 * 获取提交订单按钮element
	 * @throws IOException 
	 * */
	public WebElement getSubmitOrderElement() throws IOException {
		return element(getByLocator.getLocator("submitOrder"));
	}

}
