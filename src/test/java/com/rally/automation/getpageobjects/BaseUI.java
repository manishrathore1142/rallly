package com.rally.automation.getpageobjects;

import com.rally.automation.utilities.SeleniumWait;
import static com.rally.automation.utilities.ReadPropertyFile.readConfigPropFile;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class BaseUI {

	WebDriver driver;
	String Page;
	protected SeleniumWait wait;

	/**
	 * @Constructor
	 * @param driver
	 * @param pageName
	 */
	protected BaseUI(WebDriver driver, String pageName) {
		this.driver = driver;
		this.Page = pageName;
		this.wait = new SeleniumWait(driver, Integer.parseInt(readConfigPropFile("Config.properties", "timeout")));
	}

	/****************************************************************************************************
	 * 
	 * Selenium jar file functions
	 * 
	 ******************************************************************************************************/

	// Remove hard Wait option
	protected void hardWait(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * @Function getPageTitle - It will get the page title.
	 * @return
	 */
	protected String getPageTitle() {
		return driver.getTitle().trim();
	}

	/**
	 * @Function getCurrentURL - it will get the current url.
	 * @return
	 */
	public String getCurrentURL() {
		hardWait(3);
		return driver.getCurrentUrl();
	}

	/**
	 * @Function selectProvidedTextFromDropDown - select the visible text from the
	 *           drop down.
	 * @param el
	 * @param text
	 */
	protected void selectProvidedTextFromDropDown(WebElement el, String text) {
		wait.waitTillElementGetVisible(el);
		Select sel = new Select(el);
		sel.selectByVisibleText(text);
	}

	/**
	 * @Function selectByValueFromDropDown - select from dropdown according to value
	 * @param el
	 * @param value
	 */
	protected void selectByValueFromDropDown(WebElement el, String value) {
		wait.waitTillElementGetVisible(el);
		Select sel = new Select(el);
		sel.selectByValue(value);
		;
	}

	/**
	 * @Function refreshPage - reload or refresh the page.
	 */
	public void refreshPage() {
		driver.navigate().refresh();
		logMessage("Page refreshed by Webdriver");
	}

	/**
	 * @Function reloadPage - reload the page.
	 */
	public void reloadPage() {
		driver.findElement(By.xpath("//body")).sendKeys(Keys.F5);
		wait.waitForPageToLoad();
	}

	/**
	 * @Function logMessage - It will print the log message
	 * @param message
	 */
	public void logMessage(String message) {
		Reporter.setEscapeHtml(true);
		Reporter.log(message, true);
	}

	/****************************************************************************************************
	 * 
	 * JavaScript functions
	 * 
	 ******************************************************************************************************/
	/**
	 * @Function scrollDownUsingJS - it will scroll down to the specific element
	 *           using js.
	 * @param element
	 */
	protected void scrollDownUsingJS(WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0, -100000)");
		hardWait(5);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		hardWait(1);
		jse.executeScript("window.scrollBy(0,-350)");
		hardWait(5);
	}

	/**
	 * @Function clickUsingJS - it will click on the element using js.
	 * @param element
	 */
	public void clickUsingJS(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		try {
			executor.executeScript("arguments[0].click();", element);

		} catch (StaleElementReferenceException sre) {
			System.out.println("Stale Exeception handled.");
			hardWait(1);

		}
	}

	/****************************************************************************************************
	 * 
	 * Action functions
	 * 
	 ******************************************************************************************************/
	/**
	 * @Function hoverOverElement - using action we will hover on the web element.
	 * @param element
	 */
	protected void hoverOverElement(WebElement element) {
		Actions hoverOver = new Actions(driver);
		hoverOver.moveToElement(element).build().perform();
	}

	/**
	 * @Function clickUsingAction - we can click on the element using action.
	 * @param element
	 */
	protected void clickUsingAction(WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
		hardWait(2);
		act.moveToElement(element).click().build().perform();
		logMessage("[Action]: clicked on element given");
	}

	/**
	 * @Function doubleClick - we can double click on the element using action.
	 * @param element
	 */
	protected void doubleClick(WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
		hardWait(2);
		act.doubleClick(element).build().perform();
		logMessage("Step: Double clicked on element given");
	}
	
	protected void enterTextUsingAction(WebElement element, String text)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).click().build().perform();
		act.moveToElement(element).sendKeys(text).build().perform();
		logMessage("[INFO]: Able to enter the text using action class. "+text);
	}
	
	
}
