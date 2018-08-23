package com.Mainjava;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class TestBase {

	
	public static Properties prop;
	public static WebDriver driver;
	
	//final static Logger logger = Logger.getLogger(TestBase.class);
	

	public static XSSFWorkbook book;
	public static XSSFSheet sheet;

	public static ExtentReports reports;
	public static ExtentTest logger;

	//public static String TestData="C:\\Geetha(selenium)\\eclipse-workspace\\JAVA_Examples\\src\\Com\\qa\\transfora\\TestData.xlsx";

	public TestBase() {
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Geetha(selenium)\\eclipse-workspace\\JAVA_Examples\\src\\Com\\qa\\config\\config.properties");
			prop.load(ip); 

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	@Test
	public static void initialize() {
		
		if (prop.getProperty("browser").equals("chrome")) {
			//logger.info("browser name:"+prop.getProperty("browser"));
			System.setProperty("webdriver.chrome.driver","C:\\Users\\gmaddirala\\Downloads\\Selenium files\\chromedriver_win32\\chromedriver.exe"); //path of chromedriver executable file
			driver = new ChromeDriver();
			//logger.info("launched Chrome");
		} else if (prop.getProperty("browser").equals("FF")) {
			//logger.info("browser name:"+prop.getProperty("browser"));
			System.setProperty("webdriver.gecko.driver","C:\\Users\\gmaddirala\\Downloads\\Selenium files\\geckodriver-v0.17.0-win64\\geckodriver.exe"); //path of geckodriver executable file
			driver = new FirefoxDriver();
			//logger.info("launched Firefox");
		}
		
		/*
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);*/

		driver.get(prop.getProperty("url"));
		
	}
	
	
		
}
