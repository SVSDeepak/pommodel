package TestCaseDemo;

import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Browsers.browser;
import Excel.logindata;
import Locators.page2object;
import Pages.page1;
import Pages.page2;
import Screenshot.capture;

public class test2 {
	
	@BeforeMethod
	public void openbrowser()
	{
		browser.init("test2report");
		browser.openBrowser();
		browser.navigateToUrl();
		
	}
	
	@DataProvider(name="dp1")
	public Object[][] data() throws Exception
	{
		Object[][] obj=logindata.readExcel(0);
		return obj;
		
	}
	
	@Test(dataProvider = "dp1")
	public void Testloginbutton(String name,String password,String expected)
	{
		page1.enterusername(name);
		page1.enterpassword(password);
		page1.click();
		Assert.assertEquals(page2.MenuName(),expected);


	}
	
	@AfterMethod
	public void closebrowser() throws InterruptedException
	{
		browser.closeBrowser();
	}


}
