package com.pagefactory.testcases;

import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
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
import com.pagefactory.pages.session.settings.SecurityAndLoginPage;
import com.pagefactory.pages.util.Constants;
import com.pagefactory.pages.util.DataUtil;
import com.pagefactory.pages.util.ExtentManager;
import com.pagefactory.testcases.basetest.BaseTest;

public class ChangePicTest extends BaseTest {
	
	@Test(dataProvider="getData")
	public void changePicTest(Hashtable<String,String> data) {
				
		
		test=rep.createTest("Change Picture Test");
		
		if(!DataUtil.isRunnable(testName, xls) || data.get("RunMode").equals("N") ) {
			
			test.log(Status.SKIP, "Skipping test as Run Mode is No");
			throw new SkipException("Skipping test as Run Mode No");
			
		}
		
		
		init(data.get("Browser"));
		
		LaunchPage launchPage=new LaunchPage(driver,test);
		PageFactory.initElements(driver, launchPage);
		
        LoginPage loginPage=launchPage.gotoLoginPage();
		
		Object page=loginPage.doLogin(data.get("UserName"),data.get("Password"));
		
		String actualResult="";
		
		if(page instanceof LandingPage) {
			
			actualResult="success";
		}
		
		else
			
		{
			
			actualResult="Unsuccessful";
			
									
		}	
		
		if(!actualResult.equals(data.get("Expected Result"))) {
			
			reportFailure("login unsuccessfull with given credentials ");
		}
		else {
			
			
			
		}
		
		if(page instanceof LoginPage) {
			
			
		}else {
			
			LandingPage landingPage=(LandingPage)page;
			GeneralSettingPage generalSettingPage=landingPage.getMenu().gotoSetting();
			
			SecurityAndLoginPage securityAndLoginPage=	generalSettingPage.goToSecurityAndLoginPage();
		}
		
		
		
		test.log(Status.PASS, "Test Passed");
		
	
		
	}
	
	
}
