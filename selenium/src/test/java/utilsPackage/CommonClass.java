package utilsPackage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonClass {
	WebDriver driver;

	public void setupBrowser(String browserName) {
		String currentDir = System.getProperty("user.dir");
		boolean browserInstance;
		System.out.println(currentDir);
		switch (browserName.toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", currentDir + "/DriversFolder/chromedriver");
			driver = new ChromeDriver();
			browserInstance = true;
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", currentDir + "/DriversFolder/geckodriver");
			driver = new FirefoxDriver();
			browserInstance = true;
			break;
		default:
			System.out.println("Browser not launched");
			browserInstance = false;
		}
		driver.manage().window().maximize();
		System.out.println("Browser Status: " + browserInstance);
	}

	public WebDriver getBrowserDriver() {
		return driver;
	}

	public void getSpecficURL(String url) {
		driver.get(url);
		String currentUrl = driver.getCurrentUrl();
		if (currentUrl.contains(url)) {
			System.out.println("The Url Loaded in Browser: " + driver.getCurrentUrl());
		} else {
			System.out.println("Current Url and Expected Url Mismatched");
			driver.close();
		}
	}

	// Closes the browser
	public void closeBrowser() {
		driver.close();
		System.out.println("***Browser Closed***");
	}

	public void sendKeys(String element, String elementData) {
		driver.findElement(By.xpath(element)).sendKeys(elementData);
		System.out.println(elementData + " entered at given element " + element);
	}

	public void clearField(String element) {
		System.out.println("Default value at the field is: " + driver.findElement(By.xpath(element)).getText());
		driver.findElement(By.xpath(element)).clear();
		System.out.println("Value at the field after clearing is: " + driver.findElement(By.xpath(element)).getText());
	}

	public void clickButton(String element) {
		String buttonName = driver.findElement(By.xpath(element)).getText();
		driver.findElement(By.xpath(element)).click();
		System.out.println("Clicked on " + buttonName + " button");
	}

	public void submitButton(String element) {
		driver.findElement(By.xpath(element)).submit();
		System.out.println("Submitted Form of Element: " + element);
	}

	public void isDisplayedCheck(String element) {
		boolean check = driver.findElement(By.xpath(element)).isDisplayed();
		if (check) {
			System.out.println("Element passed: " + element + " as found");
		} else {
			System.out.println("Element passed: " + element + " as not found.");
		}
	}

	public void isEnabledCheck(String element) {
		boolean check = driver.findElement(By.xpath(element)).isEnabled();
		if (check) {
			System.out.println("Element passed: " + element + " is enabled");
		} else {
			System.out.println("Element passed: " + element + " is not enabled.");
		}
	}

	public void isSelectedCheck(String element) {
		boolean check = driver.findElement(By.xpath(element)).isSelected();
		if (check) {
			System.out.println("Element passed: " + element + " is selected");
		} else {
			System.out.println("Element passed: " + element + " is not selected.");
		}
	}

	public void explicitTimeout(String element, int waitTime) throws TimeoutException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(element))));
			System.out.println("Given Element " + element + "Found");
		} catch (Exception message) {
			System.out.println("TimeOut Exception: " + message);
			driver.close();
		}
	}

	public void fluentWait(String element, int waitTime) {
		Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(waitTime)).pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(element))));
		System.out.println("Given Element " + element + " of type XPath Found");
	}

	public void getTitle(String expectedTitle) {
		String actualTitle = driver.getTitle();
		if (actualTitle.equalsIgnoreCase(expectedTitle)) {
			System.out.println("Recived expected title");
		} else {
			System.out.println("Title mismatch");
		}
	}

	public void navigateTo(String Url) {
		driver.navigate().to(Url);
		System.out.println("Navigated to " + Url + " succesfully");
	}

	public void navigateBack() {
		driver.navigate().back();
		System.out.println("***Navigated Back***");
	}

	public void navigateForward() {
		driver.navigate().forward();
		System.out.println("***Navigated Forward***");
	}

	public void navigateRefreash() {
		driver.navigate().refresh();
		System.out.println("***Refreash Successful***");
	}

	public void textCompare(String expectedText, String element) {
		driver.findElement(By.xpath(element)).getText().equalsIgnoreCase(expectedText);
	}

	public void acceptAlert() {
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	}

	public void dismissAlert() {
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
	}

	public void sendKeysAndAccept(String messageData) {
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().sendKeys(messageData);
		driver.switchTo().alert().accept();
	}

	public void switchToTabByIndex(int indexValue) {
		ArrayList<String> tabsList = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabsList.get(indexValue));
	}

	public void switchToTabByTitle(String expectedTabTitle) {
		String currentTabName = driver.getWindowHandle();
		ArrayList<String> tabsList = new ArrayList<String>(driver.getWindowHandles());
		for (String currentTab : tabsList) {
			if (driver.switchTo().window(currentTab).getTitle().equalsIgnoreCase(expectedTabTitle)) {
				System.out
						.println("Switched to: " + driver.getTitle() + " and the expected tab is: " + expectedTabTitle);
				break;
			} else {
				driver.switchTo().window(currentTabName);
			}
		}
	}

	public void scrollByLocation() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
	}

	public void scrollTo() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	public void scrollInToView(String element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement elementDetail = driver.findElement(By.xpath(element));
		js.executeScript("arguments[0].scrollIntoView();", elementDetail);
	}

	public void switchFrameByIndex(int index) {
		driver.switchTo().frame(index);
	}

	public void switchFrameByName(String FrameName) {
		driver.switchTo().frame(FrameName);
	}

	public void switchFrameByElement(String element) {
		driver.switchTo().frame(driver.findElement(By.xpath(element)));
	}

	public void selectByInd(int indexValue, String element) {
		Select option = new Select(driver.findElement(By.xpath(element)));
		option.selectByIndex(indexValue);
	}

	public void selectByVal(String value, String element) {
		Select option = new Select(driver.findElement(By.xpath(element)));
		option.selectByValue(value);
	}

	public void selectByText(String optionName, String element) {
		Select option = new Select(driver.findElement(By.xpath(element)));
		option.selectByVisibleText(optionName);
	}

	public void switchToParentFrame() {
		driver.switchTo().parentFrame();
	}

	public void switchToDefaultFrame() {
		driver.switchTo().defaultContent();
	}

//		Moves the mouse over the element passed
	public void moveToElement(String element) {
		WebElement elementPointer = driver.findElement(By.xpath(element));
		Actions ac = new Actions(driver);
		ac.moveToElement(elementPointer).build().perform();
	}

//		Takes two parameters as source and target and drags from source and drops at target location
	public void dragAndDrop(String firstElement, String secoundElement) {
		WebElement source = driver.findElement(By.xpath(firstElement));
		WebElement target = driver.findElement(By.xpath(secoundElement));
		Actions ac = new Actions(driver);
		ac.dragAndDrop(source, target).build().perform();
	}

//		mouse click
	public void clickLeftMouseKey() {
		Actions ac = new Actions(driver);
		ac.click().build().perform();
	}

//		double click
	public void doubleClickLeftMouseKey() {
		Actions ac = new Actions(driver);
		ac.doubleClick().build().perform();
	}

//		context/right click
	public void clickRightMouseKey() {
		Actions ac = new Actions(driver);
		ac.contextClick().build().perform();
	}
}
