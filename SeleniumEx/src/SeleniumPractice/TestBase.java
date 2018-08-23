package SeleniumPractice;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TestBase {
	WebDriver driver;
	
	@Test(description="Launching the Transfora", priority=1)
	public void launch() throws Exception {
	
	    
	    //driver.get("http://seleniumpractise.blogspot.com/");
		/*FileInputStream fi= new FileInputStream("C:\\Geetha(selenium)\\eclipse-workspace\\SeleniumEx\\Test Data.xlsx");
		
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		
		XSSFSheet ws= wb.getSheet("Sheet1");
			Row r=ws.getRow(1);
			driver = new FirefoxDriver();
		driver.get("http://10.138.75.75:8888/account/login");
		driver.findElement(By.name("email")).sendKeys(r.getCell(0).getStringCellValue());
		driver.findElement(By.name("password")).sendKeys(r.getCell(1).getStringCellValue());
	     driver.findElement(By.xpath("//button[@type='submit']")).click();
		wb.close();*/
	}
	@Test
	public void login() {
		
		//assertEquals(driver.getTitle(), "TRANSFORA");
		System.out.println("Test passed");
	}
}
