package pageobjects;

import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ItemsPage extends CommonPage {

	public ItemsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	//List<WebElement> items = driver.findElements(By.cssSelector("[class='card-body']"));
	
	@FindBy(css = "[class='card-body']")
	List<WebElement> items;
	
	//@FindBy(css ="#toast-container")
	By successMessage = By.cssSelector("#toast-container");
	
//	@FindBy(css ="div[class*='ngx-spinner-overlay']")
	By spinner = By.cssSelector("div[class*='ngx-spinner-overlay']");
	
	@FindBy(css = "[routerlink*='cart']")
	WebElement cart;
	
	By itemsNames = By.cssSelector("h5 b");
	By itemAddCart = By.xpath("parent::h5/following-sibling::button[2]");
	

	public Stream<WebElement> getItems(){
		return items.stream();
	}
	
	public void addItemsToCart(List<String> itemsList) {
		items.stream().map(item -> 
			item.findElement(itemsNames)
		).filter(item1 -> itemsList.contains(item1.getText())).forEach(itemToCart -> {
			itemToCart.findElement(itemAddCart).click();
		//	waitForElementToAppear(successMessage);
		//	waitForElementToDisappear(spinner);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} );
	}
	
	
	
	

}
