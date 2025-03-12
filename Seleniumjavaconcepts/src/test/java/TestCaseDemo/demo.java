package TestCaseDemo;

import Browsers.browser;
import Pages.page1;
import Pages.page2;
import Screenshot.capture;

public class demo {

	public static void main(String[] args) throws Exception {
		
		browser.openBrowser();
		browser.navigateToUrl();
		page1.enterusername("Admin");
		capture.screenShot("username");
		page1.enterpassword("admin123");

		if(page1.Title().equals("OrangeHRM"))
		{
			System.out.println("Title matched with expected");
		}
		else
		{
			System.out.println("Title is not matched with expected");
			
		}
		page1.click();
		
		if(page2.Username().equals("manda user"))
		{
			System.out.println("user matched with expected");
		}
		else
		{
			System.out.println("user is not matched with expected");
			
		}
		capture.screenShot("page2");
		page2.optionclick("time");
		
		browser.closeBrowser();
		

	}

}
