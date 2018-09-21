package com.imooc.selenium.page;

import java.io.IOException;

import org.openqa.selenium.WebElement;

import com.imooc.selenium.base.DriverBase;
import com.imooc.selenium.util.getByLocator;

public class OrderPayPage extends BasePage{

	public OrderPayPage(DriverBase driver) {
		super(driver);
	}
	
	/**
	 * 获取订单信息订单element，检查是否生成订单
	 * @throws IOException 
	 * */
	public WebElement getOrderNameElement() throws IOException {
		return element(getByLocator.getLocator("orderText"));
	}
	
	/**
	 * 获取支付页面课程名称element
	 * */
	public WebElement getOrderCourseNameElement() throws IOException{
		return element(getByLocator.getLocator("orderCourseName"));
	}
	
	/**
	 * 获取微信支付按钮element
	 * */
	public WebElement getWXPayElement() throws IOException{
		return element(getByLocator.getLocator("wxpay"));
	}
	
	/**
	 * 获取立即支付按钮element
	 * */
	public WebElement getOrderPayElement() throws IOException{
		return element(getByLocator.getLocator("orderpay"));
	}
	
	
	

}
