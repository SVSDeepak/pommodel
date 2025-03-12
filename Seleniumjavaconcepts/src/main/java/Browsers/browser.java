package Browsers;

import java.time.Duration;
import java.util.Properties;

import org.apache.commons.math3.geometry.spherical.twod.Edge;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class browser {
	
	/* Neccessary objects declared globally */
	
	public static WebDriver driver;
	public static WebElement element;
	public static WebDriverWait wait;
	public static Actions act;
	public static Select select;
	
	public static ExtentReports extent;
	public static ExtentSparkReporter reporter;
	public static ExtentTest logger1;
	
	public static void init(String reportname)
	{
		extent=new ExtentReports();
		reporter=new ExtentSparkReporter(System.getProperty("user.dir")+"//target//Extentreports//"+reportname+".html");
	}
	
	/*
	 * Open the browser based on the choice
	 */
	public static void openBrowser()  {
		
		extent.attachReporter(reporter);
		logger1=extent.createTest("opening browser");
		logger1.log(Status.INFO, "Opening the browser");
		try {
			String choice = utility.properties("browser"); 
			if (choice.equalsIgnoreCase("Chrome"))
				driver = new ChromeDriver();
			else if (choice.equalsIgnoreCase("Edge"))
				driver = new EdgeDriver();
			else if (choice.equalsIgnoreCase("Firefox"))
				driver = new FirefoxDriver();
			logger1.log(Status.PASS, "The browser has been opened successfully");
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("Browser - openBrowser "+e);
			logger1.log(Status.FAIL, "The browser has not been opened");
		}
		extent.flush();
	}
	
		/*
		 * Pauses the URL of the application
		 */
		public static void navigateToUrl() {
			extent.attachReporter(reporter);
			logger1=extent.createTest("Navigating to url");
			logger1.log(Status.INFO, "Navigate to resepective url page");
			try {
				String Url = utility.properties("url");
				driver.get(Url); 
				driver.manage().window().maximize();
				act = new Actions(driver);
				String title=driver.getTitle();
				wait = new WebDriverWait(driver, Duration.ofSeconds(30));
				wait.until(ExpectedConditions.titleIs(title));
				logger1.log(Status.PASS, "Successfully navigated to provided url page");
			} catch (Exception e) {
				System.out.println("Browser - navigatetoUrl "+e);
				logger1.log(Status.FAIL,"Error occured in navigating to url");
			}
			extent.flush();
		}
		/*
		 * Closes the Browser
		 */
		public static void closeBrowser() {
			extent.attachReporter(reporter);
			logger1=extent.createTest("Closing browser");
			logger1.log(Status.INFO,"Closing the browser");
			try {
				driver.quit();
				logger1.log(Status.PASS,"Browser has been closed successfully");
			} catch (Exception e) {
				System.out.println("Browser - closeBrowser "+e);
				logger1.log(Status.FAIL,"Error occured in closing the browser");
			}
			extent.flush();
		}
		

}
