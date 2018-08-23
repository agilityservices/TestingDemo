package Practicals;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class handleMultiplewindoes {

	@Test
	public void getintoNaukri(){
		WebDriver driver;
		
		
			System.setProperty("webdriver.chrome.driver","C:\\Users\\gmaddirala\\Downloads\\Selenium files\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.get("https://www.naukri.com/");
			
			String parentWindow=driver.getWindowHandle();
			Set<String> allWindows=driver.getWindowHandles();
			System.out.println("parent" + driver.getTitle());
			System.out.println("no of windows" + allWindows.size());
			
		
	}
}
