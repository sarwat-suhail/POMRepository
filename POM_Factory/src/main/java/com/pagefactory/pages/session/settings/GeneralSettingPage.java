package com.pagefactory.pages.session.settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.pagefactory.base.BasePage;
import com.pagefactory.pages.util.Constants;

public class GeneralSettingPage extends BasePage {

	public GeneralSettingPage(WebDriver driver,ExtentTest test) {
		
		super(driver,test);
	}
	
	
	@FindBy(how=How.XPATH,using=Constants.SECURITY_LOGIN_LINK)
	public WebElement securityandlogin;
	
	public SecurityAndLoginPage goToSecurityAndLoginPage() {
		securityandlogin.click();
		
		
		
		SecurityAndLoginPage securityAndLoginPage=new SecurityAndLoginPage(driver,test);
		PageFactory.initElements(driver,securityAndLoginPage );
		return securityAndLoginPage;
	}
}
