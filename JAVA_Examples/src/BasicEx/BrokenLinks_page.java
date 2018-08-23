package BasicEx;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BrokenLinks_page {

	@BeforeTest	
	public void openurl() throws Exception{
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver","C:\\Users\\gmaddirala\\Downloads\\Selenium files\\geckodriver-v0.17.0-win64\\geckodriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.softwaretestingmaterial.com");
		Thread.sleep(5000);
		List<WebElement> links=driver.findElements(By.tagName("a"));
		for (int i = 0; i < links.size(); i++) {
			String url=links.get(i).getAttribute("href");
			System.out.println(i + "url is " + url);
			//verifylinks(url);
		}
		
	}
	@Test
	public void verifylinks(String urllink){
		
		
		
	}
	
	
}
