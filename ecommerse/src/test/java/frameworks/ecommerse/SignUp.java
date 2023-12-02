package frameworks.ecommerse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SignUp extends Base{

	@Test
	public void signUp() {
		driver.findElement(By.className("btn1")).click();
		driver.findElement(By.cssSelector("#firstName")).sendKeys(prop.getProperty("firstname"));
		driver.findElement(By.cssSelector("#lastName")).sendKeys(prop.getProperty("lastname"));
		driver.findElement(By.cssSelector("#userEmail")).sendKeys(prop.getProperty("email"));
		driver.findElement(By.cssSelector("#userMobile")).sendKeys(prop.getProperty("phone"));
		Select select = new Select(driver.findElement(By.cssSelector("[class*='select']")));
		select.selectByVisibleText(prop.getProperty("occupation"));
		String gender = prop.getProperty("gender").equalsIgnoreCase("male")?"Male":"Female";
		driver.findElement(By.cssSelector("[value='"+gender+"']")).click();
		driver.findElement(By.id("userPassword")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.id("confirmPassword")).sendKeys(prop.getProperty("password"));
		WebElement ageCheck =  driver.findElement(By.cssSelector("[type='checkbox']"));
		if(!ageCheck.isSelected())
			ageCheck.click();
		driver.findElement(By.cssSelector("[name='login']")).click();
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(driver.findElement(By.xpath("//h1[contains(text(),'Account Created Successfully')]")).isDisplayed());
		softAssert.assertTrue(driver.findElement(By.cssSelector("button[class*='primary']")).isDisplayed());
		softAssert.assertAll();
		
		
	}
	
}
