package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPlace extends CommonPage{

	Actions actions;
	public OrderPlace(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		 actions = new Actions(driver); 
	}
	
	
	@FindBy(css = "[placeholder='Select Country']")
	WebElement selectCountry;
	@FindBy(xpath = "//*[text()=' India']")
	WebElement india;
	@FindBy(css="[class*='submit']")
	WebElement submit;
	
	public void enterCountry(String country) {
		actions.moveToElement(selectCountry).click().build().perform();
		actions.sendKeys(country).build().perform();
	}
	
	public void selectCountry(String country) {
		actions.moveToElement(driver.findElement(By.xpath("//*[text()=' "+country+"']"))).click().build().perform();
	}
	
	public void submit() {
		submit.click();
	}
	
	public void signOut() {
		super.signOut();
	}
}
