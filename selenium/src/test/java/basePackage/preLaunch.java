package basePackage;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import utilsPackage.CommonClass;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class preLaunch {
	CommonClass com;
	static WebDriver driver;

	@Parameters({ "browser", "url" })

	@BeforeTest
	public void beforeTest(String browser, String url) {
		com = new CommonClass();
		com.setupBrowser(browser);
		com.getSpecficURL(url);
		driver = com.getBrowserDriver();
	}

	@AfterTest
	public void afterTest() {
//		com.closeBrowser();
	}

}
