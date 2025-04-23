package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * This class consists of generic methods related to selenium tool
 * @author ADMIN
 * 
 */
public class SeleniumUtility {
	

	/**
	 * this method will maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	/**
	 * this method will minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}
	
	/**
	 * this method will add implicitly wait to the code
	 * @param driver
	 */
	public void addImplicitlyWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	/**
	 * this method will add explicitly wait to the code
	 * mam note - this method will wait for particular element to be visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * this method will wait for particular element to be clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This method will handle dropdown by index
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	
	/**
	 * this method will handle dropdown by visible text
	 * @param element
	 * @param visibleText
	 */
	public void handleDropDown(WebElement element, String visibleText) {
		Select s = new Select(element);
		s.selectByVisibleText(visibleText);
	}

	/**
	 * this method will handle dropdown by value
	 * @param value
	 * @param element
	 */
	public void handleDropDown(String value, WebElement element) {
		Select s = new Select(element);
		s.selectByValue(value);
	}
	
	/**
	 * this method will handle drag and drop action by clickAndHold and release
	 * @param driver
	 * @param value
	 * @param targetValue
	 */
	public void dragAndDropAction(WebDriver driver, WebElement value, WebElement targetValue) {
		Actions a = new Actions(driver);
		a.clickAndHold(value).release(targetValue).perform();
	}
	
	/**
	 * this method will handle right click action by contextClick and doubleClick
	 * @param driver
	 * @param element
	 * @param doubleClick
	 */
	public void rightClickAction(WebDriver driver, WebElement element, WebElement doubleClick) {
		Actions act = new Actions(driver);
		act.contextClick(element).doubleClick(doubleClick).perform();
		driver.switchTo().alert().accept();
	}
	
	/**
	 * this method will perform mouse hover action
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
		
	}
	
	/**
	 * this method will perform double click action
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	/**
	 * this method will perform click and hold action
	 * @param driver
	 * @param element
	 */
	public void clickAndHoldAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.clickAndHold(element).perform();
	}
	
	/**
	 * this method will perform scroll action by using the element 
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.scrollToElement(element).perform();
	}
	
	/**
	 * this method will handle frames by using index
	 * @param driver
	 * @param index
	 */
	public void handleFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	
	/**
	 * this method will handle frames by Id or Name
	 * @param driver
	 * @param frameElement
	 */
	public void handleFrame(WebDriver driver, String IDorName ) {
		driver.switchTo().frame(IDorName);
	}

	/**
	 * this method will handle frame by WebElement
	 * @param driver
	 * @param frameElement
	 */
	public void handleFrame(WebDriver driver, WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}

	/**
	 * this method will switch the control back to immediate parent
	 * @param driver
	 */
	public void switchToParent(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	
	/**
	 * this method will switch the control back to main page by ignoring all parent frames
	 * @param driver
	 */
	public void switchToDefault(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	/**
	 * this method will handle switch to window
	 * @param driver
	 * @param address
	 */
	public void windowHandle(WebDriver driver, String windowHandle) {
		driver.switchTo().window(windowHandle);
	}
	
	/**
	 * this method will accept alert pop up
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	/**
	 * this method will dismiss alert pop up
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * this method will capture the alert text and return to caller
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}
	
	
	public void enterAlertData(WebDriver driver, String alertData) {
		driver.switchTo().alert().sendKeys(alertData);
	}
	
	/**
	 * this method will scroll down by 500 units
	 * @param driver
	 */
	public void scrollDown(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("Window.scrollBy(0,500);", "");
	}
	
	/**
	 * this method will scroll up by 500 units
	 * @param driver
	 */
	public void scrollUp(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("Window.scrollBy(0,-500);", "");
	}
	
	/**
	 * this method will scroll Right by 500 units
	 * @param driver
	 */
	public void scrollRight(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("Window.scrollBy(500,0);", "");
	}
	
	/**
	 * this method will scroll Left by 500 units
	 * @param driver
	 */
	public void scrollLeft(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("Window.scrollBy(-500,0);", "");
	}

	
	/**
	 * This method will capture the screen shot and return the path to Caller
	 * @param driver
	 * @param screenShotName
	 * @return
	 * @throws IOException
	 */
	public String captureScreenShot(WebDriver driver,String screenShotName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\ScreenShots\\"+screenShotName+".png"); //tsname_date_Time
		FileHandler.copy(src, dst);
		
		return dst.getAbsolutePath(); //For Extent reports
	}
	
	
	
	
	
	
	

}
