package basePackage;

import static org.testng.Assert.assertTrue;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestSample extends preLaunch {
	String title = "My Store";

	@Parameters("url")

	@Test
	public void urlValidation(String url) {
		Reporter.log("Expected Url: " + url);
		String currentUrl = driver.getCurrentUrl();
		Reporter.log("Current Url: " + currentUrl);
		assertTrue(currentUrl.contains(url), "Url Mismatched");

	}

	@Test
	public void tileValidation() {
		Reporter.log("Expected Tile: " + title);
		String currenttitle = driver.getTitle();
		System.out.println("Current Url: " + driver.getTitle());
		Reporter.log("Actaul Title: " + currenttitle);
		assertTrue(currenttitle.equals(title), "Title Mismatch");

	}
}
