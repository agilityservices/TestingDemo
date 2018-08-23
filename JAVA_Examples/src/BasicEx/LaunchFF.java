package BasicEx;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import Com.qa.transfora.Testutil.Utility;

public class LaunchFF extends launching {
	LaunchFF obj;
	Utility util;
	Handlebootstrapdrop boot;
	
	@Test(priority=1,groups="")	
	public void Checktitle() throws Exception{
		obj= new LaunchFF();
		obj.get();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		System.out.println("page title is"+ driver.getTitle());
	}
	
	@Test(priority=2,groups="Smoke_Testing")
	public void screenshot(){
		util=new Utility();
		util.CaptureScreenshot(driver, "Home");
	}
	
	@Test(priority=3)
	public void clickonbootstrapdrop(){
		
	boot= new Handlebootstrapdrop();
		boot.ClickonSortedlistField();
	}
	
}
