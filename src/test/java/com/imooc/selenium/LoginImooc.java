package com.imooc.selenium;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginImooc {
	public WebDriver driver;
	
	public void Initial() {
		System.setProperty("webdriver.chrome.marionette", "E:\\dependency pac\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.imooc.com/");
		driver.manage().window().maximize();
		
	}

	
	public void Login(String loginName,String loginPass) throws InterruptedException, IOException {
//		String userBy = "name";
//		String nameElement = "email";
		//login_pass
//		String passBy = "name";
//		String passElement = "password";
		//login_button
//		String buttonBy = "xpath";
//		String buttonElement = "//*[@id=\"signup-form\"]/div[5]/input";
		
		//以下是获取用户名
		/*String headerBy = "id";
		String headerElement = "header-avator";
		String user_infoBy = "xpath";
		String user_infoElement = "//*[@id=\"header-user-card\"]/div/div/div[1]/div/a/span";
		String real_loginName = "宝慕林2576717";
		*/
		
		//打开网站，并点开登录弹框
		this.Initial();
		driver.findElement(By.id("js-signin-btn")).click();
		Thread.sleep(3000);
		
		//输入登录信息，点击登录
		WebElement user_name = this.element(this.bystr("login_name"));
//		user_name.isDisplayed();
		WebElement user_password = this.element(this.bystr("login_pass"));
//		user_password.isDisplayed();
		WebElement loginButton = this.element(this.bystr("login_button"));
//		loginButton.isDisplayed();
		user_name.sendKeys(loginName);//loginName
		user_password.sendKeys(loginPass);//loginPass
		loginButton.click();
		this.takeScreenShot();
		/*Thread.sleep(3000);
		WebElement header = this.element(this.bystr(headerBy,headerElement));
		Actions ac = new Actions(driver);
		ac.moveToElement(header).perform();
		Thread.sleep(3000);
	
		String user_info = this.element(this.bystr(user_infoBy,user_infoElement)).getText();
		if(user_info.equals(real_loginName)) {
			System.out.println("登录成功！");
		}else {
			System.out.println("登录失败！");
		}*/
		
//		System.out.println(user_info);
	}

	/**封装findElement
	 * @return */
	
	public WebElement element(By by) {
		WebElement ele = driver.findElement(by);
		return ele;
	}
	
	/**
	 * 失败截图
	 * @throws IOException 
	 * */
	public void takeScreenShot() throws IOException {
		long date = System.currentTimeMillis();
		String path = String.valueOf(date);
		String currentPath = System.getProperty("user.dir");
		path = path+".png";
		String screenPath = currentPath+"/"+path;
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File(screenPath));
		
	}
	
	
	/**封装By方法
	 * @throws IOException */
	
	public By bystr(String login_name) throws IOException {
		ProUtil proUtil = new ProUtil("element.properties");
		String loginname_value = proUtil.getPro(login_name);
		String loginname_By = loginname_value.split(">")[0];
		String loginname_Element = loginname_value.split(">")[1];
		if(loginname_By.equals("id")) {
			return By.id(loginname_Element);
		}else if(loginname_By.equals("name")) {
			return By.name(loginname_Element);
		}else if(loginname_By.equals("className")) {
			return By.className(loginname_Element);
		}else{
			return By.xpath(loginname_Element);
		}
		
	}
	
	//关闭浏览器
	public void CloseBrowser(){
		driver.close();	
	}
	
	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		LoginImooc loginImooc = new LoginImooc();
		
		
		HashMap<String,String> user = new HashMap<String,String>();
		user.put("17521620315", "liufang1994");
//		user.put("102792557@qq.com","lydialiu1994");
		Iterator it = user.entrySet().iterator();
		while(it.hasNext()) {
			@SuppressWarnings("rawtypes")
			Map.Entry entry = (Map.Entry) it.next(); 
			String username = (String) entry.getKey();
			String userpass = (String) entry.getValue();
			loginImooc.Login(username,userpass);
		}
		loginImooc.CloseBrowser();
	}

}
