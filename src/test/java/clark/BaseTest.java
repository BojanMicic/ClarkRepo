package clark;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void setUp() throws Exception {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://staging.clark.de/de/app/contracts?cv=2");

		try {
			driver.findElement(By.className("cucumber-cookie-banner-accept-btn")).click();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	    public void tearDown(){
			driver.quit();
	    }

		public WebDriver getDriver() {
			return driver;
		}
}
