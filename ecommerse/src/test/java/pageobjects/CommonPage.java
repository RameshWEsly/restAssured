package pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonPage {

	WebDriverWait wait;
	WebDriver driver;

	public CommonPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(css = "[routerlink*='cart']")
	WebElement cart;
	@FindBy(xpath = "//button[contains(text(),'Sign Out')]")
	WebElement signOut;
	
	By signout = By.xpath("//button[contains(text(),'Sign Out')]");

	public void waitForElementToAppear(By elementLocator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
	}

	public void waitForElementToDisappear(By elementLocator) {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(elementLocator));
	}
	
	public void clickOnCart() {
		cart.click();
	}
	
	public void signOut() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(signout));
		signOut.click();
	}
}

