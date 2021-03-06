package Com.qa.transfora.Tests;
//fdfsfs


import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import Com.qa.transfora.TestBase;
import Com.qa.transfora.Testutil.Utility;

public class TransforaTests extends TestBase {
	
	static String TestData=".\\src\\Com\\qa\\transfora\\TestData.xlsx";
	
	
	@BeforeMethod
	public void setup(){
		reports= new ExtentReports("C:\\Geetha(selenium)\\eclipse-workspace\\JAVA_Examples\\src\\BasicEx\\Reports\\extent.html");
		logger=reports.startTest("Extent report");
		TestBase.initialize();
		logger.log(LogStatus.INFO, "Navigated to login page");
	}
	
	//Test method to execute
	@Test(dataProvider="Getdata", description= "Verify login to Transfora")
	public void VerifyLogin(String username, String password) throws Exception{
		logger=reports.startTest("Verify login to Transfora");
		driver.findElement(By.name("email")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		Thread.sleep(5000);
		assertEquals(driver.findElement(By.xpath("//*[@aria-label='Inbox']")).isDisplayed(), true); 
		logger.log(LogStatus.INFO, "Login to the Inbox");
		driver.findElement(By.className("user-image")).click();
		logger.log(LogStatus.INFO, "Clicked My profile");
		}		
	//-----------getting data from excel storing in object----------------
	@DataProvider(name="Getdata")
	public Object[][] getdatafromexcel() throws Exception{
		Object data[][] = getExcelData("Sheet1");
		return data;
	}	
																
	public static Object[][] getExcelData(String sheetname) throws Exception, IOException{
		FileInputStream file=null;
		try{
			file=new FileInputStream(TestData);
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		try{
		book=new XSSFWorkbook(file);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		sheet=book.getSheet(sheetname);
		
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for (int i = 0; i<sheet.getLastRowNum(); i++) {
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
		}
	//-------------------------------------------------------------------------------------
	
	@AfterMethod
	public void teardown(ITestResult result){
		if(ITestResult.FAILURE==result.getStatus()){
			//If status= fail, takes screenshot
			try{
		/*File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("./ScreenshotFiles/"+result.getName()+ System.currentTimeMillis() + ".png"));
			logger.log(LogStatus.INFO, "Failed screenshot taken");*/
				
				String screenshot_path=Utility.CaptureScreenshot(driver, result.getTestName());
				String image= logger.addScreenCapture(screenshot_path);
				logger.log(LogStatus.FAIL, "Title verification", image);
			}catch (Exception e) {
				System.out.println("Exception while taking screenshot" + e);
			}
	    }//if condition
		reports.endTest(logger);
		reports.flush();
				
	}
}
	
