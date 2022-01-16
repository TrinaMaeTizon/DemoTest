package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.BasePage;

public class HomePage extends BasePage{
	
		WebElement webElement; 
		WebDriverWait wait;
		By xpathSelector;
		
		public String getMenuLabels() {
			String getDashboard = "";
			try {
				xpathSelector = By.xpath("//div[@class='sidebar-menu-wrap']//a[contains(.,'Dashboard')]");
				wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.presenceOfElementLocated(xpathSelector));
				webElement = driver.findElement(xpathSelector);
				getDashboard = webElement.getText().trim();
				
				
			} catch (Exception e) {
				
			} 
			return getDashboard;
		}

}
