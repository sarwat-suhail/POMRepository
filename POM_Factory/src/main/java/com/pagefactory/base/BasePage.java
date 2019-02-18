package com.pagefactory.base;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.pagefactory.pages.common.TopMenu;
import com.pagefactory.pages.util.ExtentManager;

public class BasePage {

	public WebDriver driver;
	public ExtentTest test;
	public TopMenu menu;
	
	
	public BasePage() {}
	
	public BasePage(WebDriver driver,ExtentTest test) {
		
		this.driver=driver;
		this.test=test;
		menu=new TopMenu(driver,test);
		PageFactory.initElements(driver,menu);
	}
	
	public void takeScreenShot() {
		try {
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String fileName="file.png";
		FileUtils.copyFile(src, new File(ExtentManager.screenshotFolderPath+fileName));
		
		test.addScreenCaptureFromPath(ExtentManager.screenshotFolderPath+fileName);
		
		}catch(Exception ex) {
			
			ex.printStackTrace();
		}
		
	}
	
	public boolean isElementPresent(String locator){
		
	int s=driver.findElements(By.xpath(locator)).size();
	
	if(s==0) {
		return false;}
	else
		{return true;}
	
	}
	
	
		

	
	public TopMenu getMenu() {
		
		return menu;
	}
	
	public String verifyTitle(String expectedTitle) {
		
		
		return "";
	}
	
	
}
