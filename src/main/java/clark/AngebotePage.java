package clark;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AngebotePage extends BasePage{
	
	public AngebotePage(WebDriver driver) { 
		super(driver);
	}
	
	public void selectInsurance(String type) {;
		driver.findElement(By.cssSelector("p[title='"+type+"']")).click();
	}

}

