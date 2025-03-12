package TestCaseDemo;


import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
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

public class Test0 extends browser {
	
	
	@BeforeTest
	public void openbrowser()
	{
		browser.init("test0report");
		browser.openBrowser();
		browser.navigateToUrl();
		
	}
	
	@DataProvider(name="title")
	public Object[] data()
	{
		Object[] obj= {"OrangeHRM"};
		return obj;
	}
	
	@Test(priority=1 ,dataProvider = "title")
	public void TestTitle(String title) 
	{
		Assert.assertEquals(browser.driver.getTitle(), title);
		capture.screenShot("title");
		Reporter.log("Screenshot taken by name title");
	}
	
	
	@Test(priority=2)
	public void Testloginbutton()
	{
		page1.enterusername("Admin");
		page1.enterpassword("admin123");
		page1.click();
		Assert.assertTrue(true);
	}
	
	@Test(dependsOnMethods = "Testloginbutton")
	public void TestMenu()
	{
		page2.optionclick("leave");
		Assert.assertEquals(page2object.menuName().getText(),"Leave");
	}
	
	@AfterTest
	public void closebrowser()
	{
		browser.closeBrowser();
	}

}
