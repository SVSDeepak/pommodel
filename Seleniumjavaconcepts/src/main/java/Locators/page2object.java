package Locators;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Browsers.browser;

public class page2object extends browser {
	
	public static By searchmenuelements=By.cssSelector("[class=\"oxd-text oxd-text--span oxd-main-menu-item--name\"]");
	public static By searchusername=By.cssSelector("[class=\"oxd-userdropdown-name\"]");
	public static By searchumenuname=By.cssSelector("[class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']");
	
	public static List<WebElement> menuelements()
	{
		wait=new WebDriverWait(browser.driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchmenuelements));
		
		return driver.findElements(searchmenuelements);
	}
	
	public static WebElement username()
	{
		wait=new WebDriverWait(browser.driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchusername));
		return driver.findElement(searchusername);
	}
	public static WebElement menuName()
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(searchumenuname));
		return driver.findElement(searchumenuname);
	}

}
