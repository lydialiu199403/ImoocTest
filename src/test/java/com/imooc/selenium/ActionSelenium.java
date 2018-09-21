package com.imooc.selenium;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Listeners({TestNGListenerScreen.class})
public class ActionSelenium {
	
	public WebDriver driver;

	/*** ��ʼ��Driver ***/
	@Test
	public void Initial() {
		System.setProperty("webdriver.chrome.marionette", "E:\\dependency pac\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.imooc.com");
		driver.manage().window().maximize();
	}
	
	/*** ������¼ 
	 * @throws InterruptedException ***/
	@Test
	public void InputBox() throws InterruptedException {
		driver.findElement(By.id("js-signin-btn")).click();
		Thread.sleep(5000);
		WebElement username = driver.findElement(By.name("email"));
		username.sendKeys("17521620315");
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("liufang1994");
		WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"signup-form\"]/div[5]/input"));
		loginBtn.click();
		Thread.sleep(3000);
	}
	
	/*** radio 
	 * @throws InterruptedException ***/
	@Test
	public void RadioBox() throws InterruptedException {
		driver.get("https://www.imooc.com/user/setprofile");
		driver.findElement(By.cssSelector("#setting-profile > div.common-title > a")).click();
		Thread.sleep(3000);
		//�������޸��Ա��ܡ�ͨ����λ���ڵ�����ȡ����3��input���ݣ����ܡ��С�Ů��,Ȼ��ѡ���2��Ԫ��
//		WebElement sex_node = driver.findElement(By.cssSelector("#profile > div:nth-child(4) > div"));
//		List<WebElement> radios = sex_node.findElements(By.tagName("input"));		
//		radios.get(1).click();
		//���ο���ֱ��ͨ��xpath��λʵ��
		driver.findElement(By.xpath("//*[@id=\"profile\"]/div[4]/div/label[3]/input")).click();
		driver.findElement(By.id("profile-submit")).click();   //��������
	}
	
	
	/***����ͷ�� upfile
	 * @throws InterruptedException **/
	
	public void UpdateAvator() throws InterruptedException {
		driver.get("https://www.imooc.com/user/setbindsns");
		//ʹ��ִ��js��ʽ
//		String js = "document.getElementsByClassName('update-avator')[0].style.bottom='0'";
//		JavascriptExecutor jsE = (JavascriptExecutor)driver;
//		jsE.executeScript(js);
//		Thread.sleep(5000);
		//ʹ�ò������ʵ��
		WebElement header = driver.findElement(By.className("update-avator"));
		Actions ac = new Actions(driver);
		ac.moveToElement(header).perform();
		
		
		driver.findElement(By.className("js-avator-link")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("upload")).sendKeys("E:\\test.jpg");
		driver.findElement(By.linkText("ȷ��")).click();
	}
	
	/**
	 * ѡ��������SelectOption
	 * @throws InterruptedException 
	 * */
	
	public void SelectOption() throws InterruptedException {
		driver.get("https://www.imooc.com/user/setprofile");
		driver.findElement(By.cssSelector("#setting-profile > div.common-title > a")).click();
		WebElement form = driver.findElement(By.id("profile"));
		WebElement job = form.findElement(By.id("job"));
		Thread.sleep(3000);
	    Select downList = new Select(job);
	    downList.selectByIndex(4);
	    driver.findElement(By.id("profile-submit")).click();
	}
	
	
	/**
	 * ������ move to
	 * @throws InterruptedException */
	public void MoveToElement() throws InterruptedException {
		WebElement father_node = driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div/div[9]/div[1]/a/span"));
		Actions action = new Actions(driver);
		action.moveToElement(father_node).perform();
		driver.findElement(By.linkText("������")).click();
		
		//�л�����
		Set<String> handles = driver.getWindowHandles();//��ȡ���д��ھ��
		
		String current_handle = driver.getWindowHandle(); //��ȡ��ǰ���ھ��
		
		for(String handle:handles) {
			if (handle.equals(current_handle)) {
				continue;    //����ǵ�ǰ���ڣ����������ѭ��������������һ��
			}
			System.out.println(handle);
			driver.switchTo().window(handle);
			
		}
		Thread.sleep(3000);
		driver.findElement(By.linkText("΢����")).click();
	}
	
	/**
	 * 失败截图
	 * @throws IOException 
	 * */
	@Test
	public void takeScreenShot() throws IOException {
		long date = System.currentTimeMillis();
		String path = String.valueOf(date);
		String currentPath = System.getProperty("user.dir");
		path = path+".png";
		String screenPath = currentPath+"/"+path;
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File(screenPath));
		
	}
	
	
	/**
	 * �˳������ 
	 **/
	
	public void CloseBrowser(){
		driver.close();
		
	}
	
	/*public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ActionSelenium action = new ActionSelenium();
		action.Initial();
//		action.InputBox();
//		action.RadioBox();
//		action.UpdateAvator();
//		action.SelectOption();
		action.MoveToElement();
//		action.CloseBrowser();
*/	
	//}

}
