package SeleniumPractice;

import java.util.Iterator;
import java.util.Set;

import org.apache.xmlbeans.impl.xb.xsdschema.impl.AllImpl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ClickAmazon_MultipleWindows {

	
WebDriver driver;
	
	@Test 
	public void closeAmazon(){
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\gmaddirala\\Downloads\\chromedriver_win32\\chromedriver.exe"); 
		driver = new ChromeDriver();
		driver.get("https://www.naukri.com/");
		//System.out.println(driver.getTitle());
		
		String parent=driver.getWindowHandle();
		
		Set<String> allWindows=driver.getWindowHandles();
		
		Iterator<String> itr= allWindows.iterator();
		while (itr.hasNext()) {
			String child=itr.next();
			
			if(!parent.equals(child)){
				driver.switchTo().window(child);
				String title=driver.getTitle();
				if(title.equalsIgnoreCase("Amazon")){
					driver.close();
				}
				
			}
			
		}
		driver.switchTo().window(parent);
		System.out.println(driver.getTitle());
	
	}
}
