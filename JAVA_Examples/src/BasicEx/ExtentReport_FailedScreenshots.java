package BasicEx;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import Com.qa.transfora.TestBase;

public class ExtentReport_FailedScreenshots extends TestBase{
	 public ExtentReports extent;
	
	    @BeforeTest
	    public void startReport(){
	    //ExtentReports(String filePath,Boolean replaceExisting) 
	    //filepath - path of the file, in .htm or .html format - path where your report needs to generate. 
	    //replaceExisting - Setting to overwrite (TRUE) the existing file or append to it
	    //True (default): the file will be replaced with brand new markup, and all existing data will be lost. Use this option to create a brand new report
	    //False: existing data will remain, new tests will be appended to the existing report. If the the supplied path does not exist, a new file will be created.
	    extent = new ExtentReports ("C:\\Geetha(selenium)\\eclipse-workspace\\JAVA_Examples\\src\\BasicEx\\Reports\\ExtentReport.html", true);
	    	    
	    }
	    
	           //This method is to capture the screenshot and return the path of the screenshot.
	    
	    public static String getScreenhot(WebDriver driver, String screenshotName) throws Exception {
	    String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	    TakesScreenshot ts = (TakesScreenshot) driver;
	    File source = ts.getScreenshotAs(OutputType.FILE);
	                   //after execution, you could see a folder "FailedTestsScreenshots" under src folder
	    String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/"+screenshotName+dateName+".png";
	    File finalDestination = new File(destination);
	    FileUtils.copyFile(source, finalDestination);
	    return destination;
	    }
	     
	    @Test
	    public void passTest(){
	    //extent.startTest("TestCaseName", "Description")
	    //TestCaseName � Name of the test
	    //Description � Description of the test
	    //Starting test
	    logger = extent.startTest("passTest");
	    Assert.assertTrue(true);
	    //To generate the log when the test case is passed
	    logger.log(LogStatus.PASS, "Test Case Passed is passTest");
	    }
	    
	    
	    @Test
	    public void failTest(){
	                   //My intention is to fail this method
	                   //If this method fails, then it goes to the @AfterMethod and calls the getScreenshot method and captures a screenshot and place it in the extent reports
	    logger = extent.startTest("failTest");
	    System.setProperty("webdriver.chrome.driver","C:\\Users\\gmaddirala\\Downloads\\Selenium files\\chromedriver_win32\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.get("http://tryout.transfora.com/");	    
	    System.out.println("url is "+ driver.getCurrentUrl());
	    Assert.assertEquals(driver.getCurrentUrl() , "http://tryout.transfora.com/");
	    logger.log(LogStatus.PASS, "Test Case (failTest) Status is passed");
	    }
	    
	    
	    @Test
	    public void skipTest(){
	    logger = extent.startTest("skipTest");
	    throw new SkipException("Skipping - This is not ready for testing ");
	    }
	    
	    @AfterTest
	    public void getResult(ITestResult result) throws Exception{
	    if(result.getStatus() == ITestResult.FAILURE){
	    logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
	    logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
	    //To capture screenshot path and store the path of the screenshot in the string "screenshotPath"
	                           //We do pass the path captured by this mehtod in to the extent reports using "logger.addScreenCapture" method. 
	                           String screenshotPath =getScreenhot(driver, result.getName());
	    //To add it in the extent report 
	    logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotPath));
	    }else if(result.getStatus() == ITestResult.SKIP){
	    logger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
	    }
	    // ending test
	    //endTest(logger) : It ends the current test and prepares to create HTML report
	    extent.endTest(logger);
	    extent.flush();
	 
	    }
	    
}
