package Locators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Browsers.browser;

public class page1objects extends browser{
	
	public static By searchusername=By.name("username");
	public static By searchpassword=By.name("password");
	public static By searchlogin=By.cssSelector("[type=\"submit\"]");
	
	public static WebElement username()
	{
		wait=new WebDriverWait(browser.driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchusername));
		return driver.findElement(searchusername);
	}
	
	public static WebElement password()
	{
		return driver.findElement(searchpassword);
	}
	
	public static WebElement login()
	{
		return driver.findElement(searchlogin);
	}
	

}
