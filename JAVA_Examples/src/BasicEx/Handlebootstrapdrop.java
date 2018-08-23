package BasicEx;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Handlebootstrapdrop extends launching {

	
	public void ClickonSortedlistField(){
		WebElement unsortedlist=driver.findElement(By.id("unsorted"));
		List<WebElement> OptionsInSortedlist=unsortedlist.findElements(By.tagName("option"));
		
		for(int i=0;i<=OptionsInSortedlist.size();i++){
			try{
				if(OptionsInSortedlist.get(i).getText().equalsIgnoreCase("b")){
					OptionsInSortedlist.get(i).click();
					
				}
				System.out.println("Drop down name" + OptionsInSortedlist.get(i).getText());
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
	}


}
