package clark;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class ManagerMainPage extends BasePage{
	
	public ManagerMainPage(WebDriver driver) {
		super(driver);
	}

	public void closeDoYouLikeClarkModal() {
		try {
			driver.findElement(By.className("cucumber-close-modal")).click();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void assertContract(String contract){
		Assert.assertTrue(driver.findElement(By.xpath("//div[text()='"+contract+"']")).isDisplayed());
	}
	
}

