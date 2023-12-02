package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends CommonPage {

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="userEmail")
	WebElement username;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(css = "#login")
	WebElement login;
	
	
	public void login(String user, String paword) {
		username.sendKeys(user);
		password.sendKeys(paword);
		login.click();
	}
	
	public void load(String url) {
		driver.get(url);
	}
}

