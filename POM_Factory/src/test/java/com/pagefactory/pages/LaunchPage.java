package com.pagefactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.pagefactory.base.BasePage;
import com.pagefactory.pages.LoginPage;
import com.pagefactory.pages.util.Constants;

public class LaunchPage extends BasePage {

	
	public LaunchPage(WebDriver driver,ExtentTest test) {
		
		super(driver,test);
		
	}
	
	public LoginPage gotoLoginPage() {
		
		//menu.gotoSetting();
		
		test.log(Status.INFO, "Navigating to website--"+Constants.WEBSITE_URL);
		driver.get(Constants.WEBSITE_URL);
		driver.manage().window().maximize();
		
		LoginPage loginPage=new LoginPage(driver,test);
		PageFactory.initElements(driver, loginPage);
		return loginPage;
		
	}
	
	
	
}
