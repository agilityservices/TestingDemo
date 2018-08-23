package Com.qa.transfora.Tests;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindingBrokenLinks {

	static WebDriver driver;
	@BeforeTest
	public void get(){
		System.setProperty("webdriver.chrome.driver","C:\\Users\\gmaddirala\\Downloads\\Selenium files\\chromedriver_win32\\chromedriver.exe"); //path of chromedriver executable file
		driver = new ChromeDriver();
		driver.get("tryout.transfora.com");
	  
		
	}
	public static void verifyLink(String URLLink){
		try {
			 //Use URL Class - Create object of the URL Class and pass the urlLink as parameter 
			 URL link = new URL(URLLink);
			 // Create a connection using URL object (i.e., link)
			 HttpURLConnection httpConn =(HttpURLConnection)link.openConnection();
			 //Set the timeout for 2 seconds
			 httpConn.setConnectTimeout(2000);
			 //connect using connect method
			 httpConn.connect();
			 //use getResponseCode() to get the response code. 
			 if(httpConn.getResponseCode()== 200) { 
			 System.out.println(URLLink+" - "+httpConn.getResponseMessage());
			 }
			 if(httpConn.getResponseCode()== 404) {
			 System.out.println(URLLink+" - "+httpConn.getResponseMessage());
			 }
			 }
			 //getResponseCode method returns = IOException - if an error occurred connecting to the server. 
			 catch (Exception e) {
			 //e.printStackTrace();
			 }
	}
	@Test
	public static void FindAllLinks(){
		List<WebElement> links = driver.findElements(By.tagName("a")); 
		 //To print the total number of links
		 System.out.println("Total links are "+links.size()); 
		 //used for loop to 
		 for(int i=0; i<links.size(); i++) {
		 WebElement element = links.get(i);
		 //By using "href" attribute, we could get the url of the requried link
		 String url=element.getAttribute("href");
		 //calling verifyLink() method here. Passing the parameter as url which we collected in the above link
		 //See the detailed functionality of the verifyLink(url) method below
		 verifyLink(url); 
		 } 
	}
}
