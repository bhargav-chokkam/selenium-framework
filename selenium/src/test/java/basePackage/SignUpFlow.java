package basePackage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjectModel.HomePage;


public class SignUpFlow extends preLaunch {
	HomePage homePageObject;

	@BeforeClass
	public void loginPageObjectInit() {
		homePageObject = new HomePage(driver);
	}
	@Test
	public void singUpFlow() {
		homePageObject.signIn();
	}
}
