package Pages;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import Browsers.browser;
import Browsers.utility;
import Locators.page1objects;
import Screenshot.capture;

public class page1 extends browser{
	
	
	//Method for getting the actual title
	public static String Title() 
	{
		extent.attachReporter(reporter);
		logger1=extent.createTest("Title");
		logger1.log(Status.INFO, "Screenshot");
		wait=new WebDriverWait(browser.driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(page1objects.searchlogin));
		logger1.addScreenCaptureFromPath(capture.screenShot("title"));
		extent.flush();
		return driver.getTitle();
	}
	
	//Entering user name method
	
	public static void enterusername(String str) 
	{
		extent.attachReporter(reporter);
		logger1=extent.createTest("Entering username");
		logger1.log(Status.INFO,"Entering the username into the field variable");
		try 
		{	
				page1objects.username().sendKeys(str);
				logger1.log(Status.PASS,"username entered successfully");
		}
		catch(Exception E)
		{
			System.out.println("Username :"+E);
			logger1.log(Status.FAIL,"Error occured in entering the username");
		}
		extent.flush();
		
	}
	
	//Entering password method
		
		public static void enterpassword(String str) 
		{
			extent.attachReporter(reporter);
			logger1=extent.createTest("Entering password");
			logger1.log(Status.INFO,"Entering the password into the field variable");
			try
			{
				page1objects.password().sendKeys(str);
				logger1.log(Status.PASS,"Password entered successfully");
			}
			catch(Exception E)
			{
				System.out.println("Password :"+E);
				logger1.log(Status.FAIL,"Error occured in entering the password");
			}
			extent.flush();
			
			
		}
	
	//clicking method
	
	public static void click() 
	{
		extent.attachReporter(reporter);
		logger1=extent.createTest("Click login");
		logger1.log(Status.INFO,"Checking the funtionality of login button");
		try
		{
			page1objects.login().click();
			logger1.log(Status.PASS, "Login successfull");
		}
		catch(Exception E)
		{
			System.out.println("Click :"+E);
			logger1.log(Status.FAIL, "Login failed");
		}
		extent.flush();
	}
		
	

}
