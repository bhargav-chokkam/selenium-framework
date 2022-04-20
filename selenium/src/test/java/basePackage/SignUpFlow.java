package basePackage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjectModel.LoginPage;

public class SignUpFlow extends preLaunch {
	LoginPage obj;

	@BeforeClass
	public void loginPageObjectInit() {
		obj = new LoginPage(driver);
	}
	@Test
	public void singUpFlow() {
		obj.signIn();
	}
}
