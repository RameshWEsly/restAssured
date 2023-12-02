package frameworks.ecommerse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public WebDriver driver;
	public Properties prop;

	@BeforeTest
	public void init() throws IOException {
		prop = new Properties();
		prop.load(new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\TestData\\config.properties")));
		
		String browser = prop.getProperty("browser");
		switch(browser) {
		case "chrome": case "CHROME": case "Chrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.setAcceptInsecureCerts(true);
			driver = new ChromeDriver(options);
			break;
		case "edge": case "EDGE": case "Edge":
			System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\msedgedriver.exe");
			driver  =  new EdgeDriver();
			break;
		default:
			break;
	}
			
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(prop.getProperty("uri"));
	}
	public void login() {
		driver.findElement(By.id("userEmail")).sendKeys(prop.getProperty("email"));
		driver.findElement(By.id("userPassword")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.cssSelector("#login")).click();
	}
	
	@AfterTest
	public void cleanup() {
		//driver.close();
		prop.clear();
	}
	
}
