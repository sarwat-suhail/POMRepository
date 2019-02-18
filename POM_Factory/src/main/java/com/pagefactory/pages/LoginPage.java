package com.pagefactory.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.pagefactory.base.BasePage;
import com.pagefactory.pages.session.LandingPage;
import com.pagefactory.pages.util.Constants;

public class LoginPage extends BasePage {


	
	@FindBy(xpath=Constants.LOGINPAGE_USERNAME)
	public WebElement Email;
	
	@FindBy(xpath=Constants.LOGINPAGE_PASSWORD)
	public WebElement pass;
	
	@FindBy(xpath=Constants.LOGINPAGE_SUBMIT)
	public WebElement submit;
	
	public LoginPage(WebDriver driver, ExtentTest test) {
		
		super(driver,test);
		
	}
	
	public Object doLogin(String username, String password) {
		
		test.log(Status.INFO, "Trying to Login with "+username+"\\"+password);
		
		Email.sendKeys(username);
		
		pass.sendKeys(password);
		submit.click();
		
		boolean result=isElementPresent(Constants.PROFILE_LINK);
		if(result) {
			//test.log(Status.PASS, "Login Success");
			LandingPage landingPage=new LandingPage(driver,test);
		    PageFactory.initElements(driver, landingPage);
			return landingPage;
			}
		else
		{//reportFailure("not able to login");
			//test.log(Status.FAIL, "Login Failed");
			LoginPage loginPage=new LoginPage(driver,test);
			PageFactory.initElements(driver, loginPage);
			return loginPage;
		}
			
		
	}
	
	
	
	
}
