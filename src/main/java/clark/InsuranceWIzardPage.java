package clark;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InsuranceWIzardPage extends BasePage{
	
	public InsuranceWIzardPage(WebDriver driver) {
		super(driver);
	}

	WebDriverWait wait = new WebDriverWait(driver, 30);

	private WebElement element = null;

	public WebElement weiterBtn() throws InterruptedException {
		Thread.sleep(2000);
		element = driver.findElement(By.className("_appearance-primary_dsfphm"));
		return element;
	}

	public void clickWeiterBtn() throws InterruptedException {
		weiterBtn().click();
	}

	public void clickAngebotAnfordenBtn() {
		driver.findElement(By.className("btn-next-split")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("_header_ie5k4r")));
	}

	public void clickZumAngebotBtn() {
		driver.findElement(By.className("_button_dsfphm")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("_appearance-positive-accent_6w7zsa")));
	}

	public void clickJetzRegistrierenBtn() throws InterruptedException {
		weiterBtn().click();
	}

	public void chooseRecomendedOption() throws InterruptedException {
		weiterBtn().click();
	}

	public void enterRegistrationCredentials(){
		String pass = System.getenv("CLARK_PASSWORD");
		driver.findElement(By.cssSelector("input[type='email']")).sendKeys("testautomation+" + getUniqueCode() + "@clark.de");
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys(pass);
	}

	public void selectHerrRadio() {
		driver.findElement(By.className("cucumber-profile-customer-gender-male")).click();
	}

	public void enterGeneralUserDetails(String firstname, String lastname, String birthdate){
		driver.findElement(By.cssSelector("input[name='firstName']")).sendKeys(firstname);
		driver.findElement(By.cssSelector("input[name='lastName']")).sendKeys(lastname);
		driver.findElement(By.cssSelector("input[name='birthdate']")).sendKeys(birthdate);
	}

	public void enterPlaceDetails(String street, String houseNumber, String zipcode, String city, String phoneNumber){
		driver.findElement(By.cssSelector("input[name='street']")).sendKeys(street);
		driver.findElement(By.cssSelector("input[name='houseNumber']")).sendKeys(houseNumber);
		driver.findElement(By.cssSelector("input[name='zipcode']")).sendKeys(zipcode);
		driver.findElement(By.cssSelector("input[name='city']")).sendKeys(city);
		driver.findElement(By.cssSelector("input[name='phoneNumber']")).sendKeys(phoneNumber);
	}

	public void selectOption(String option) throws InterruptedException {
		driver.findElement(By.xpath("//h2[text()='"+option+"']")).click();
		
		Thread.sleep(2000);		
	}
	
	public void chooseNextWorkingDayOption() {
		driver.findElement(By.className("cucumber-next-working-day-choice")).click();
	}

	public void chooseNoPreviousDemageOption() {
		driver.findElement(By.className("cucumber-previous-damage-no-choice")).click();
	}

	public void enterIban(String iban){
		driver.findElement(By.cssSelector("input[name='iban']")).sendKeys(iban);

	}

	public void selectSepaCheckbox() {
		driver.findElement(By.className("_checkbox_qoz8b6")).click();
	}

	public void clickZumAbschlussBtn() throws InterruptedException {
		weiterBtn().click();
		Thread.sleep(2000);
	}

	public void clickZurVertragsubersichtBtn() throws InterruptedException {
		weiterBtn().click();
	}
	
	
}

