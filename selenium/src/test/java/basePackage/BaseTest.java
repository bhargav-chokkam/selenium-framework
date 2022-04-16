package basePackage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import utilsPackage.CommonClasses;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class BaseTest {
	CommonClasses com;
	static WebDriver driver;
	String browser = "chrome";
	String url = "https://www.facebook.com/";

	@BeforeTest
	public void beforeTest() {
		com = new CommonClasses();
		com.setupBrowser(browser);
		com.getSpecficURL(url);
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
