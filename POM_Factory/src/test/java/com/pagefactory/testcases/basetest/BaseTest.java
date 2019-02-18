
package com.pagefactory.testcases.basetest;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.pagefactory.pages.util.Constants;
import com.pagefactory.pages.util.DataUtil;
import com.pagefactory.pages.util.ExtentManager;
import com.pagefactory.pages.util.Xls_Reader;

public class BaseTest {

	public WebDriver driver;
	public ExtentReports rep=ExtentManager.getInstance(Constants.REPORT_PATH);
	public ExtentTest test;
	public Xls_Reader xls=new Xls_Reader(Constants.DATA_PATH);
	public SoftAssert softAssert;
	public String testName;
	public Hashtable<String,String> data;
	
	public void init(String bType) {
		
		if(!Constants.GRID_RUN) {
			// run normal 
			
		if(bType.equals("Chrome")) {
			test.log(Status.INFO, "Trying to open browser"+bType);
			
			ChromeOptions options=new ChromeOptions();
			
			options.addArguments("--disable-notifications");
			
			driver=new ChromeDriver(options);
			test.log(Status.INFO, " Opened Successfully"+bType);
		}else if(bType.equals("Mozilla")) {
			test.log(Status.INFO, "Trying to open browser"+bType);
			
			FirefoxOptions foptions=new FirefoxOptions();
			
			foptions.setProfile(new FirefoxProfile());
			foptions.addPreference("dom.webnotifications.enabled", false);
			driver=new FirefoxDriver(foptions);
			test.log(Status.INFO, " Opened Successfully"+bType);
		}
		}else {
			
			//run on grid 
			DesiredCapabilities cap=null;
			if(bType.equals("Mozilla")) {
			cap=DesiredCapabilities.firefox();
			cap.setJavascriptEnabled(true);
			cap.setPlatform(Platform.WINDOWS);
			}else if(bType.equals("Chrome")) {
				
				cap=DesiredCapabilities.chrome();
				cap.setJavascriptEnabled(true);
				cap.setPlatform(Platform.WINDOWS);
				
			}
			
			
			try {
				driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
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
public void Assertall() {
		
		if(softAssert!=null)
			softAssert.assertAll();
	}
	
public void reportFailure(String msg) {
		
		softAssert=new SoftAssert();
		
		test.log(Status.FAIL, msg);
		
		takeScreenShot();
			
	if(data.get("ProceedOnFail").equals("Y")){
			softAssert.fail();
			
	}else {
				softAssert.fail();
				softAssert.assertAll();
				
			}
			
	}
	
	@DataProvider
	public Object[][] getData(Method method){
		
		testName=method.getName();
		
		return DataUtil.getTestData(testName,xls);
		
	}
	
	@AfterMethod
	public void quit() {
		if(driver!=null) {
			
			driver.quit();
		}
		if(rep!=null)
			rep.flush();
	}
	
	
}
