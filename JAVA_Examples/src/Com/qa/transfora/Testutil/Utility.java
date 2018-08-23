package Com.qa.transfora.Testutil;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
//import org.testng.ITestResult;

import Com.qa.transfora.TestBase;

public class Utility extends TestBase{

	public static String CaptureScreenshot(WebDriver driver, String ScreenshotName){
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	try{
		FileUtils.copyFile(src, new File("C:\\Geetha(selenium)\\eclipse-workspace\\JAVA Examples\\ScreenshotsFile" +ScreenshotName+System.currentTimeMillis()+ ".png" ));
	}catch (Exception e) {
		
	}
	return ScreenshotName;
	}

}
