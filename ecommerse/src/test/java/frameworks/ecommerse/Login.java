package frameworks.ecommerse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Login extends Base{

	@Test
	public void loginTest() {
		driver.findElement(By.id("userEmail")).sendKeys(prop.getProperty("email"));
		driver.findElement(By.id("userPassword")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.cssSelector("#login")).click();
		SoftAssert softAssert = new SoftAssert();
		WebElement signOut = driver.findElement(By.xpath("//button[contains(text(),'Sign')]"));
		softAssert.assertTrue(signOut.isDisplayed());
		signOut.click();
		softAssert.assertAll();
	}
	

}
