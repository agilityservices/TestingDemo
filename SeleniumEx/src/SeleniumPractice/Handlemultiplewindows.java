package SeleniumPractice;
//abc
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Handlemultiplewindows {
	//author geetha
	WebDriver driver;
	
	@Test 
	public void getnaukri(){
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\gmaddirala\\Downloads\\chromedriver_win32\\chromedriver.exe"); 
		driver = new ChromeDriver();
		driver.get("https://www.naukri.com/");
		//System.out.println(driver.getTitle());
		
		String parent=driver.getWindowHandle();
		
		Set<String> allWindows=driver.getWindowHandles();
		System.out.println("parent" + driver.getTitle());
		System.out.println("no of windows" + allWindows.size());
		
			
			Iterator<String> itr=allWindows.iterator();
			while(itr.hasNext()){
				
				
				String childwindow=itr.next();
				if(!parent.equals(childwindow)){
					driver.switchTo().window(childwindow);
					System.out.println("child window"+ driver.getTitle());
					driver.close();
				}
				
			}
		
		
		driver.switchTo().window(parent);
	}
	
}
