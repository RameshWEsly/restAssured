package tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.Base;
import pageobjects.LoginPage;

public class LoginTest extends Base{

	public LoginTest() throws FileNotFoundException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test(enabled = true,dataProvider = "data")
	public void login(String username, String password) {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.load("https://rahulshettyacademy.com/client");
		loginPage.login(username,password);
		
	}
	
	
	@DataProvider
	public Object[][] data(){
		return new Object[][]{{"jesusramesh10@gmail.com","Grace@123"},{"jesusramesh10@gmail.com","Grace@12"}};
	}
}
