package com.pagefactory.pages.session;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.pagefactory.base.BasePage;
import com.pagefactory.pages.LoginPage;
import com.pagefactory.pages.session.ProfilePage;
import com.pagefactory.pages.util.Constants;



public class LandingPage extends BasePage {


	
	
	@FindBy(xpath=Constants.PROFILE_LINK)
	public WebElement ProfileLink;
	
	
	public LandingPage(WebDriver driver,ExtentTest test) {
		
		super(driver,test);
		
		
	}

	public ProfilePage gotoProfile() {
		
		ProfileLink.click();
		
		ProfilePage profilePage=new ProfilePage(driver,test);
		PageFactory.initElements(driver, profilePage);
		
		return profilePage;
	}
	
	
	
	
	
}
