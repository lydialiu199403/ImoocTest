package com.imooc.selenium.business;

import java.io.IOException;

import com.imooc.selenium.base.DriverBase;
import com.imooc.selenium.handle.OrderPayPageHandle;

public class OrderPayPagePro {
	public DriverBase driver;
	public OrderPayPageHandle orderPayPageHandle;
	public OrderPayPagePro(DriverBase driver) {
		this.driver = driver;
		orderPayPageHandle = new OrderPayPageHandle(driver);
	}
	
	/**
	 * 提交立即支付操作
	 * @throws IOException 
	 * */
	public void payOrder() throws IOException {
			String OrderName = orderPayPageHandle.getOrderNameText();
			String OrderCourseName = orderPayPageHandle.getOrderCourseNameText();
//			System.out.println(OrderName);
//			System.out.println("支付页面课程名称："+OrderCourseName);
			if(OrderName != null && OrderCourseName != null) {
				orderPayPageHandle.clickWXPay();
				orderPayPageHandle.clickPayNowElement();		
			}
		
	}
}
