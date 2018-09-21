package com.imooc.selenium.handle;

import java.io.IOException;

import com.imooc.selenium.base.DriverBase;
import com.imooc.selenium.page.OrderPayPage;

public class OrderPayPageHandle {
	public DriverBase driver;
	public OrderPayPage orderPayPage;
	public OrderPayPageHandle(DriverBase driver) {
		this.driver = driver;
		orderPayPage = new OrderPayPage(driver);
	}
	
	/**
	 * 获取订单信息，是否生成订单
	 * @throws IOException 
	 * */
	public String getOrderNameText() throws IOException {
		String orderNameText = driver.getText(orderPayPage.getOrderNameElement());
		return orderNameText;
	}
	
	/**
	 *获取支付页面课程名称
	 * */
	public String getOrderCourseNameText() throws IOException{
		String orderCourseNmaeText = driver.getText(orderPayPage.getOrderCourseNameElement());
		return orderCourseNmaeText;
	}
	
	/**
	 * 点击选择微信支付方式
	 * */
	public void clickWXPay() throws IOException{
		driver.click(orderPayPage.getWXPayElement());
	}
	
	/**
	 * 点击立即支付按钮
	 * */
	public void clickPayNowElement() throws IOException{
		driver.click(orderPayPage.getOrderPayElement());
	}

}
