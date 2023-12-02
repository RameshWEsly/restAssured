package frameworks.ecommerse;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ItemsList extends Base{

	
	@Test
	public void itemList() {
		
		
		login();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		List<WebElement> items = driver.findElements(By.cssSelector("[class='card-body']"));
		System.out.println("Total Items::"+items.size());
		Stream<WebElement> itemNames = items.stream().map(item -> item.findElement(By.cssSelector("h5 b")));
	//	itemNames.forEach(item -> System.out.println(item.getText()));
		Stream<WebElement> itemCard = itemNames.filter(item -> item.getText().equalsIgnoreCase("ZARA COAT 3") ||item.getText().equalsIgnoreCase("ADIDAS ORIGINAL") );
		
		//System.out.println(itemCard.count());
		itemCard.forEach(item -> {
			
			
		wait.until(ExpectedConditions.elementToBeClickable(item.findElement(By.xpath("parent::h5/following-sibling::button[2]")))).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#toast-container"))));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector("div[class*='ngx-spinner-overlay']"))));
		});

		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("[routerlink*='cart']")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[contains(text(),'Checkout')]")))).click();
		//driver.findElement(By.cssSelector("[placeholder='Select Country']")).sendKeys("India");
		//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//span[contains(text(),'India')])[2]")))).click();
		Actions actions = new Actions(driver);
		actions.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "India").build().perform();
		actions.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)"))))).click().build().perform();
		driver.findElement(By.cssSelector("[class='btnn action__submit ng-star-inserted']")).click();
	}
}
