package basePackage;

import org.testng.annotations.BeforeTest;

import utilsPackage.CommonClass;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class BaseTest {
	CommonClass com;
	static WebDriver driver;
	String browser = "chrome";

	@BeforeTest
	public void beforeTest() {
		com = new CommonClass();
		com.setupBrowser(browser);
		driver = com.getBrowserDriver();
	}

	@AfterTest
	public void afterTest() {
		com.closeBrowser();
	}

}
