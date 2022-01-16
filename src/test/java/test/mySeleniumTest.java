package test;

import org.testng.annotations.Test;

import PageObjects.LoginPage;
import Utilities.BaseTest;

public class mySeleniumTest extends BaseTest {
	
		LoginPage loginPage = new LoginPage();
	
	@Test
	public void mySeleniumTestthis () throws Exception {
		
		driver.get("https://www.phptravels.net/login");
		
		loginPage.enterEmail();
		loginPage.enterPassword();
		loginPage.clickLogin();
		
		
	}
	

}
