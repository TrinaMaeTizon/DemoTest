package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.BasePage;

public class LoginPage extends BasePage{
	
	WebDriverWait wait;
	WebElement webElement;
	By xpathSelector;
	
	public void enterEmail() throws Exception{
		try {
			xpathSelector = By.xpath("//input[@type='email']");
			wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.presenceOfElementLocated(xpathSelector));
			webElement = driver.findElement(xpathSelector);
			webElement.sendKeys("user@phptravels.com");
			
		}catch (Exception e) {
			
		}
	}
	
	public void enterPassword() throws Exception{
		try {
			xpathSelector = By.xpath("//input[@type='password']");
			webElement = driver.findElement(xpathSelector);
			webElement.sendKeys("demouser");
			
		}catch (Exception e) {
			
		}
	}
	
	public void clickLogin() throws Exception{
		try {
			xpathSelector = By.xpath("//button[@type='submit']//span[contains(.,'Login')]");
			webElement = driver.findElement(xpathSelector);
			webElement.sendKeys("demouser");
			
		}catch (Exception e) {
			
		}
	}

}
