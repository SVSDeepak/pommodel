package TestCaseDemo;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Browsers.browser;
import Locators.page2object;
import Pages.page1;
import Pages.page2;
import Screenshot.capture;

public class Test3 {
	
	@BeforeMethod
	public void openbrowser()
	{
		browser.init("test3report");
		browser.openBrowser();
		browser.navigateToUrl();
		
	}
	
//	@DataProvider(name="db3")
//	public Object[] dashboarddata()
//	{
//		
//	}
//		
	@Test
	public void TestMenu()
	{
		page1.enterusername("Admin");
		page1.enterpassword("admin123");
		page1.click();
		page2.optionclick("leave");
		Assert.assertEquals(page2object.menuName().getText(),"Leave");
	}
	
	@AfterMethod
	public void closebrowser()
	{
		browser.closeBrowser();
	}


}
