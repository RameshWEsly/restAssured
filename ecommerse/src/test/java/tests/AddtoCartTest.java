package tests;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.Base;
import pageobjects.CheckOutPage;
import pageobjects.ItemsPage;
import pageobjects.LoginPage;
import pageobjects.OrderPlace;
public class AddtoCartTest extends Base{

	public AddtoCartTest() throws FileNotFoundException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test(dataProvider = "data")
	public void addTpCart(String username,String password) {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.load("https://rahulshettyacademy.com/client");
		loginPage.login(username,password);
		ItemsPage itemsPage = new ItemsPage(driver);
		itemsPage.getItems();
		List<String>  items = new ArrayList<String>();
		items.add("ZARA COAT 3");
		items.add("ADIDAS ORIGINAL");
		itemsPage.addItemsToCart(items);
		itemsPage.clickOnCart();
	}
	
	@Test(dependsOnMethods = {"addTpCart"})
	public void cofirmOrder() {
		
		CheckOutPage checkOut =new CheckOutPage(driver);
		checkOut.CheckOut();
		OrderPlace orderPlace =new OrderPlace(driver);
		orderPlace.enterCountry("India");
		orderPlace.selectCountry("India");
		orderPlace.submit();
		orderPlace.signOut();
	}
	
	@DataProvider
	public Object[][] data(){
		return new Object[][]{{"jesusramesh10@gmail.com","Grace@123"}};
	}
	
}
