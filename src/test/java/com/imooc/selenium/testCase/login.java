package com.imooc.selenium.testCase;

import java.io.IOException;

//import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.imooc.selenium.base.DriverBase;
import com.imooc.selenium.business.CoursePagePro;
import com.imooc.selenium.business.LoginPro;
import com.imooc.selenium.business.OrderPayPagePro;
import com.imooc.selenium.business.SubmitOrderPagePro;


public class login extends CaseBase{
	public DriverBase driver;
	public LoginPro loginpro;
	public CoursePagePro coursePagePro;
	public SubmitOrderPagePro submitOrderPagePro;
	public OrderPayPagePro orderPayPagePro;
//	public static Logger logger = Logger.getLogger(login.class);
	public login(){
		this.driver = InitDriver("chrome");
		this.loginpro = new LoginPro(driver);
		this.coursePagePro = new CoursePagePro(driver);
		this.submitOrderPagePro = new SubmitOrderPagePro(driver);
		this.orderPayPagePro = new OrderPayPagePro(driver);
	}
	
	/**
	 * 打开首页并打开登录框
	 * @throws InterruptedException 
	 * */
	@Test(priority = 0)
	public void getLoginHome() throws InterruptedException {
		driver.get("http://www.imooc.com");
		driver.maxWindow();
		driver.findElement(By.id("js-signin-btn")).click();
		Thread.sleep(3000);
	}
	
	/**
	 * 登录
	 * @throws InterruptedException 
	 * */
//	@Test(dependsOnMethods= {"getLoginHome"})
	@Test(priority = 1)
	@Parameters({"username","password"})
	public void testLogin(String username,String password) throws InterruptedException {
		try {
	//		logger.debug("log4j的第一次使用");
			loginpro.login(username, password);
			Thread.sleep(3000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 点击立即购买操作
	 * @throws IOException 
	 * @throws InterruptedException 
	 * */
	@Test(priority = 2)
	public void testBuyNow() throws IOException, InterruptedException {
		driver.get("https://coding.imooc.com/class/136.html");
		coursePagePro.buyCourseNow();
	}
	
	/**
	 * 立即购买后点击 提交订单 操作
	 * @throws IOException 
	 * @throws InterruptedException 
	 * */
	@Test(dependsOnMethods= {"testBuyNow"})
	public void testSubmitOrder() throws IOException, InterruptedException {
		submitOrderPagePro.submitOrder();
		Thread.sleep(3000);
	}
	
	/**
	 * 支付页面点击选择微信支付，并跳转到微信付款页面
	 * */
	@Test(dependsOnMethods= {"testSubmitOrder"})
	public void testPayOrder() throws IOException{
		orderPayPagePro.payOrder();
	}
	
	
//	/**
//	 * 下单流程
//	 * @throws InterruptedException 
//	 * */
	/*@Test(priority = 2)
	public void buyCourse() throws InterruptedException {
		driver.get("https://coding.imooc.com/class/180.html");
		String courseName = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/span")).getText();
		System.out.println(courseName);
		driver.findElement(By.id("buy-trigger")).click();
		driver.findElement(By.linkText("提交订单")).click();
		Thread.sleep(3000);
		String orderName = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div/div[1]/span[1]")).getText();
//		String orderName = driver.findElement(By.className("cart-body")).findElement(By.className("clearfix")).findElement(By.className("order")).getText();
		System.out.println(orderName);
		if(orderName != null) {
			String orderCourseName = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/ul/li/div[1]/dl/a/dt")).getText();
			System.out.println(orderCourseName);
			Assert.assertEquals(orderCourseName, courseName,"课程名称是否一致");
		}		
	}*/
//	
	
	/**封装*/
	/**
	 *下单流程
	 * @throws IOException 
	 * @throws InterruptedException 
	 * */
	/*@Test(priority = 2)
	public void buyCourse() throws IOException, InterruptedException {
		driver.get("https://coding.imooc.com/class/195.html");
		String currentText = this.buyCourseNow();
		System.out.println(currentText);
		Thread.sleep(2000);
		this.submitOrder();
		Thread.sleep(2000);
		String getOrder = this.getOrder();
		System.out.println(getOrder);
		String orderText = this.getOrderCourse();
		System.out.println(orderText);
		if(currentText.equals(orderText)) {
			System.out.println("课程名称相同，提交订单成功");
		}
	}
	*/
	
/*	*//**
	 * 封装element,也可以是父节点
	 * *//*
	public WebElement getElement(By by) {
		return driver.findElement(by);
	}
	
	*//**
	 * 封装 通过父节点获取子节点
	 * *//*
	public WebElement getElement(WebElement element,By by) {
		return element.findElement(by);
	}
	
	*//**
	 * 封装 通过子节点获取课程名称
	 * *//*
	public String getText(WebElement element) {
		return element.getText();
	}
	
	*//**
	 * 点击立即购买，并返回课程名称
	 * @throws IOException 
	 * *//*
	public String buyCourseNow() throws IOException {
		WebElement getElement = this.getElement(getByLocator.getLocator("courseInfo"));
		WebElement getElementNode = this.getElement(getElement, getByLocator.getLocator("courseInfoText"));
		String currentText = this.getText(getElementNode);
		driver.click(this.getElement(getByLocator.getLocator("buyNow")));
		return currentText;
	}
	
	*//**
	 * 提交订单
	 * @throws IOException 
	 * *//*
	public void submitOrder() throws IOException{
		
		driver.click(this.getElement(getByLocator.getLocator("submitOrder")));
	}
	
	*//**
	 * 获取支付页面的订单信息，确认是否生成订单
	 * @throws IOException 
	 * *//*
	public String getOrder() throws IOException {
//		WebElement getElement = this.getElement(getByLocator.getLocator("orderCartBody"));
//		WebElement getElementNode = this.getElement(getElement, getByLocator.getLocator("orderClearFix"));
//		WebElement getElementText = this.getElement(getElementNode, getByLocator.getLocator("orderText"));
		String orderText = this.getText(this.getElement(getByLocator.getLocator("orderText")));
		return orderText;
	}
	
	*//**
	 * 获取支付页面的课程名称
	 * @throws IOException 
	 * *//*
	public String getOrderCourse() throws IOException {
//		WebElement getElement = this.getElement(getByLocator.getLocator("orderCourse"));
//		WebElement getElementNode = this.getElement(getElement, getByLocator.getLocator("orderCourseNode"));
		return this.getText(this.getElement(getByLocator.getLocator("orderCourseName")));
	}*/
	
	

}
