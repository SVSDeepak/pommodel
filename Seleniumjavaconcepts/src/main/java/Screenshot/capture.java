package Screenshot;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Browsers.browser;

public class capture extends browser {
	
	public static String screenShot(String name)  { 
		String path=null;
		try {
			TakesScreenshot shot = ((TakesScreenshot) driver);
			File source = shot.getScreenshotAs(OutputType.FILE);
			path = System.getProperty("user.dir") + "\\target\\ScreenShot\\" + name + ".png";
			File destination = new File(path);
			
//			FileUtils.copyFile(source, destination);
			
			//OR
			
			source.renameTo(destination);
			
		} catch (Exception e) {
			System.out.println("Screenshot");
		}
		return path;
	}

}
