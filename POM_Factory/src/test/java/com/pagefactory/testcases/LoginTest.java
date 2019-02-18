package com.pagefactory.testcases;

import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.pagefactory.pages.LaunchPage;
import com.pagefactory.pages.LoginPage;
import com.pagefactory.pages.session.LandingPage;
import com.pagefactory.pages.session.settings.GeneralSettingPage;
import com.pagefactory.pages.util.Constants;
import com.pagefactory.pages.util.DataUtil;
import com.pagefactory.pages.util.ExtentManager;
import com.pagefactory.testcases.basetest.BaseTest;

public class LoginTest extends BaseTest {
	
	
	@Test(dataProvider="getData")
	public void doLogin(Hashtable<String,String> data) {

	
    test=rep.createTest("Login Test");
    
    if(!DataUtil.isRunnable(testName, xls) || data.get("RunMode").equals("N")) {
    	test.log(Status.SKIP, "Sipping test as runmode is No");
    	throw new SkipException("Skipping test as Run mode is N");
    	
    }
	
	test.log(Status.INFO, "Opening Browser"+Constants.BROWSER_NAME);
		
		init(Constants.BROWSER_NAME);
		LaunchPage launchPage=new LaunchPage(driver,test);
		PageFactory.initElements(driver, launchPage);
		
		test.log(Status.INFO, "navigating to "+Constants.WEBSITE_URL);
				
		LoginPage loginPage=launchPage.gotoLoginPage();
		
	    Object page=loginPage.doLogin(data.get("UserName"),data.get("Password"));
	
	    String actualResult="";
		if(page instanceof LandingPage)
			{
			actualResult="success";
			
				
			
			}else
			{actualResult="Unsuccessful";
					
			}
			
		if(!actualResult.equals(data.get("Expected Result"))) {
			
			reportFailure("Not able to login");
			//test.log(Status.INFO, "Test is success ");
			//loginPage.reportFailure("Not able to login");
			
		}else {
			
			test.log(Status.INFO, "Test is success ");
			
		}
			
		if(page instanceof LoginPage) {
			
			
		} 
		
		else 
		
		{
		
		LandingPage landingPage=(LandingPage)page;
		
		GeneralSettingPage generalSettings=landingPage.getMenu().gotoSetting();
		
		test.log(Status.PASS, "Profile Test Passed ");
			
		//ProfilePage profilePage=landingPage.gotoProfile();
		
		//profilePage.getMenu().gotoSetting();
		
		//   String title=profilePage.verifyTitle("Facebook Title");
			
		
		}	
	
}}
