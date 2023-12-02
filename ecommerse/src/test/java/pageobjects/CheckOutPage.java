package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage extends CommonPage{

	public CheckOutPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	//validation
	@FindBy(css="[class='subtotal cf ng-star-inserted'] button")
	WebElement checkOut;
	
	
	public void CheckOut() {
		checkOut.click();
	}

}
