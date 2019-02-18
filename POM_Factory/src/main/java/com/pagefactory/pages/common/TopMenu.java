package com.pagefactory.pages.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.pagefactory.pages.session.settings.GeneralSettingPage;
import com.pagefactory.pages.util.Constants;

public class TopMenu {

	
	public WebDriver driver;
	public ExtentTest test;
	
	public TopMenu(WebDriver driver , ExtentTest test) {
		
		this.driver=driver;
		this.test=test;
		
	}
	
	
	@FindBy(how=How.XPATH ,using=Constants.NAVIGATIONAL_LINK )
	public WebElement logoutmenu;
	
	@FindBy(how=How.XPATH,using=Constants.SETTING_LINK)
	public WebElement setting;
	
	
	public void logOut() {
		
		
		test.log(Status.INFO, "Logging out from FaceBook Application ");
		
	}
	
	
	
	public GeneralSettingPage gotoSetting() {
		
		
		
		try {
			Thread.sleep(10000);
			logoutmenu.click();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setting.click();
		
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		GeneralSettingPage generalSettingPage=new GeneralSettingPage(driver,test);
		PageFactory.initElements(driver, generalSettingPage);
		return generalSettingPage;
	}
}
