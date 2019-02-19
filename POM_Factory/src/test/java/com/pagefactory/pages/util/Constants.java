package com.pagefactory.pages.util;

public class Constants {
	
	public static final boolean GRID_RUN=false;
	
     //URLs
	public static final String WEBSITE_URL = "http://www.facebook.com";
	
	//Locators
	public static final String LOGINPAGE_USERNAME = "//*[@id='email']";
	public static final String LOGINPAGE_PASSWORD = "//*[@id='pass']";
	public static final String LOGINPAGE_SUBMIT = "//*[@value='Log In']";
	public static final String PROFILE_LINK = "//*[@id='userNav']/ul/li/a";
	public static final String NAVIGATIONAL_LINK="//*[@id='userNavigationLabel']";
	public static final String SETTING_LINK="//ul[@role='menu']/li[12]/a";
			
	//Browser Name 
	public static final String BROWSER_NAME = "Chrome";

	public static final String REPORT_PATH = System.getProperty("user.dir")+"\\reports\\";

	 // path of data file
	
	public static final String DATA_PATH=System.getProperty("user.dir")+"\\data\\testdata.xlsx";
	
	public static final String DATASHEET_NAME="TestData";
	
	public static final String TESTSHEET_NAME="TestCases";
	
	public static final String TCID_COL="TCID";
	
	public static final String RMOD_COL="RunMode";

	public static final String SECURITY_LOGIN_LINK = "//a[@title='Security and Login']";
	
	
	
	
	
}
