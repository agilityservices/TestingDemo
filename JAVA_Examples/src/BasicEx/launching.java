package BasicEx;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

//Initialize webdriver
public class launching {
	static WebDriver driver;
	@Test
	public void get() throws Exception{
		System.setProperty("webdriver.gecko.driver","C:\\Users\\gmaddirala\\Downloads\\Selenium files\\geckodriver-v0.17.0-win64\\geckodriver.exe");
		FileInputStream fi=new FileInputStream("C:\\Geetha(selenium)\\eclipse-workspace\\JAVA_Examples\\src\\BasicEx\\Repository.properties");
		Properties src=new Properties();
		src.load(fi);
		
		driver = new FirefoxDriver();
		
		//driver.get("http://seleniumpractise.blogspot.com/");
		driver.get(src.getProperty("urlblog"));		
		
		driver.findElement(By.name("email")).sendKeys(src.getProperty("uname"));
		driver.findElement(By.name("password")).sendKeys(src.getProperty("pwd"));
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		
		}
	
}
