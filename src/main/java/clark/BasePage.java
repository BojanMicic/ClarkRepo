package clark;

import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public abstract class BasePage {
	
	WebDriver driver;
		
	public BasePage(WebDriver driverPage) {
		this.driver = driverPage;
	}
	
	public void goToAngebotePage() {
		driver.findElement(By.className("page-navigation__link--offers")).click();		
	}

	public long getUniqueCode() {
		Date date = new Date();
		//This method returns the time in millis
		long timeMilli = date.getTime();
		return timeMilli;
	}

	public void assertURL(String url) throws InterruptedException {
		Thread.sleep(2000);
		String currentURL = driver.getCurrentUrl();
		Assert.assertEquals(currentURL, url);
	}
	
}

