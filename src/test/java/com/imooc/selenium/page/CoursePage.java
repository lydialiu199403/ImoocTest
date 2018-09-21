package com.imooc.selenium.page;

import java.io.IOException;

import org.openqa.selenium.WebElement;

import com.imooc.selenium.base.DriverBase;
import com.imooc.selenium.util.getByLocator;

public class CoursePage extends BasePage{

	public CoursePage(DriverBase driver) {
		super(driver);
	}
	
	/**
	 * 获取立即购买按钮element
	 * @throws IOException 
	 * */
	public WebElement getBuyNowElement() throws IOException {
		return element(getByLocator.getLocator("buyNow"));
	}
	
	/**
	 * 获取左上角课程名称element
	 * @throws IOException 
	 * */
	public WebElement getCourseNameElement() throws IOException {
		return this.nodeElement(getByLocator.getLocator("courseInfo"), getByLocator.getLocator("courseInfoText"));
	}
	
	/**
	 * 获取加入购物车element
	 * @throws IOException 
	 * */
	public WebElement getAddCartElement() throws IOException {
		return element(getByLocator.getLocator("addCart"));
	}
	
	/**
	 * 获取右上角购物车element
	 * @throws IOException 
	 * */
	public WebElement getShopCartElement() throws IOException {
		return element(getByLocator.getLocator("shopCart"));
	}
	
	/**
	 * 获取右上角购物车数量element
	 * */
	public WebElement getShopCartNumElement() throws IOException{
		return element(getByLocator.getLocator("shopCartNum"));
	}
}

