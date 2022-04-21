package basePackage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjectModel.HomePage;
import pageObjectModel.SingUpPage;



public class SignUpFlow extends preLaunch {
	HomePage homePageObject;
	SingUpPage signUpObject;

	@BeforeClass
	public void ObjectInit() {
		homePageObject = new HomePage(driver);
		signUpObject = new SingUpPage(driver);
	}
	@Test
	public void singUpFlow() {
		homePageObject.signIn();
		signUpObject.createAccount();
	}
}
