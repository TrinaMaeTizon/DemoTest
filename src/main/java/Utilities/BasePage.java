package Utilities;

import javax.imageio.IIOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;

public class BasePage {

	protected static WebDriver driver;

	public static void setWebDriver(WebDriver driver) {
		BasePage.driver = driver;
		BasePage.driver.manage().window().maximize();
	}

	public BasePage() {
		PageFactory.initElements(driver, this);
	}

	protected void waitJStoFinish() throws Exception {
		final String script = "if(typeof window != 'undefined' && window.document) {return window.document.readyState; } else {return 'notready';}";
		try {
			ExpectedCondition<Boolean> jsLoad = thisDriver -> ((JavascriptExecutor) BasePage.driver)
					.executeScript(script).toString().equals("complete");

			Thread.sleep(500);

			new WebDriverWait(driver, 100, 500).until(jsLoad);

		} catch (Throwable th) {

			th.printStackTrace();

		}

	}

	public void takeScreenshot(String filename, String path, String name) throws Exception, IIOException {

		try {

			MyUtilities myUtilities = new MyUtilities();
			String dateTime = myUtilities.getTime();
			String pathFolder = "" + path + "\\\\" + name + "_" + dateTime + "\\\\";
			
			Shutterbug.shootPage(driver, ScrollStrategy.WHOLE_PAGE, 500, true).withName(filename).save(pathFolder);

			System.out.println("takeScreenshot PASSED");

		} catch (Exception e) {

			System.out.println("takeScreenshot FAILED" + e);


		}
		return;

	}

}
