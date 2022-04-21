package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilsPackage.CommonClass;
import utilsPackage.ReadData;

public class HomePage {
	CommonClass com;
	private WebDriver driver;
	ReadData dataObject;

	@CacheLookup
	@FindBy(xpath = "//*[@title='Log in to your customer account']")
	WebElement singIn;
	@CacheLookup
	@FindBy(xpath = "//input[@id='email_create']")
	WebElement emailElement;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		com = new CommonClass();
		dataObject = new ReadData();
		PageFactory.initElements(driver, this);
	}

	public void signIn() {
		com.clickButton(singIn);
		String email = dataObject.read("email");
		com.sendKeys(emailElement, email);

	}

}
