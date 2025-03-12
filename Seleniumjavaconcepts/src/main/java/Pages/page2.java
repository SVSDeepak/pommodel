package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import Browsers.browser;
import Locators.page1objects;
import Locators.page2object;
import Screenshot.capture;

public class page2 extends browser {
	
	
		public static String Username()
		{
			return page2object.username().getText();
		}
	
		//clicking method
	
		public static void optionclick(String str) 
		{
			extent.attachReporter(reporter);
			logger1=extent.createTest("Selection of dashboard menu");
			logger1.log(Status.INFO, "Selecting the function from the dashboard");
			
			try{
				List<WebElement> list=page2object.menuelements();
				for(WebElement e:list)
				{
					if(e.getText().equalsIgnoreCase(str))
					{	e.click();
						break; }
				}
				logger1.log(Status.PASS,"Dashboard Element selected successfully");
				}
			
			catch(Exception E)
			{
				System.out.println("Click :"+E);
				logger1.log(Status.FAIL,"Selection failed");
			}	
			extent.flush();
		}
		
		public static String MenuName()
		{
			extent.attachReporter(reporter);
			logger1=extent.createTest("Title");
			logger1.log(Status.INFO, "Screenshot");
			wait=new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(page2object.searchumenuname));
			logger1.addScreenCaptureFromPath(capture.screenShot("title2"));
			extent.flush();
			return page2object.menuName().getText();
		}
			

}
