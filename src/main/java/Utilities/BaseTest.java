package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	protected static WebDriver driver;
	WebElement webElement;
	
	@BeforeClass
	public static void setupApplication() throws Exception {
		try {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			BasePage.setWebDriver(driver);
			
		}catch(Exception e) {
			System.out.println("setupApplication Failed! "+e);
			
		} 
	}
	
	@AfterClass
	public static void closeApplication() throws Exception {
		try {
			driver.close();
			driver.quit();
			
		} catch (Exception e) {
			System.out.println("closeApplication Failed! "+e);
		}
	}
	

}
