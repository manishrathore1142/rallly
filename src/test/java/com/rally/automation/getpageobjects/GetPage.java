package com.rally.automation.getpageobjects;

import static com.rally.automation.utilities.ReadSpecFile.fetchLocatorDetails;
import static org.testng.Assert.fail;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class GetPage extends BaseUI {

	protected WebDriver driver;
	String Page;

	public GetPage(WebDriver driver, String Page) {
		super(driver, Page);
		this.driver = driver;
		this.Page = Page;
	}

	/**
	 * @Function element - it will create a webelement object for operation.
	 * 
	 * @param elementToken
	 * @return
	 */
	protected WebElement element(String elementToken) {
		return element(elementToken, "");
	}

	/**
	 * @Function element - it will create a webelement object for operation.
	 * 
	 * @param elementToken
	 * @param replace1
	 * @return
	 */
	protected WebElement element(String elementToken, String replace1) {
		WebElement elem = null;
		try {
			elem = wait.waitTillElementGetVisible(driver.findElement(getLocator(elementToken, replace1)));
		} catch (NoSuchElementException excp) {
			fail("FAILED: Element '" + elementToken + "' not found on the " + this.Page + " !!!");
		}
		return elem;
	}

	/**
	 * @Function element - it will create a webelement object for operation.
	 * 
	 * @param elementToken
	 * @param replace1
	 * @param replace2
	 * @return
	 */
	protected WebElement element(String elementToken, String replace1, String replace2) {
		WebElement elem = null;
		try {
			elem = wait.waitTillElementGetVisible(driver.findElement(getLocator(elementToken, replace1, replace2)));
		} catch (NoSuchElementException excp) {
			fail("FAILED: Element '" + elementToken + "' not found on the " + this.Page + " !!!");
		}
		return elem;
	}

	/**
	 * @Function element - it will create a webelement object for operation.
	 * 
	 * @param elementToken
	 * @param replace1
	 * @param replace2
	 * @param replace3
	 * @return
	 */
	protected WebElement element(String elementToken, String replace1, String replace2, String replace3) {
		WebElement elem = null;
		try {
			elem = wait.waitTillElementGetVisible(driver.findElement(getLocator(elementToken, replace1, replace2, replace3)));
		} catch (NoSuchElementException excp) {
			fail("FAILED: Element '" + elementToken + "' not found on the " + this.Page + " !!!");
		}
		return elem;
	}
	
	protected List<WebElement> elements(String elementToken, String replacement) {
		return wait.waitTillElementsGetVisible(driver.findElements(getLocator(elementToken, replacement)));
	}
	
	protected List<WebElement> elements(String elementToken, String replacement1, String replacement2) {
		return wait.waitTillElementsGetVisible(driver.findElements(getLocator(elementToken, replacement1, replacement2)));
	}

	protected List<WebElement> elements(String elementToken) {
		return elements(elementToken, "");
	}

	/**
	 * @Function getLocator - it will fetch the value from the spec file and return
	 *           by value.
	 * @param elementName
	 * @param replace1
	 * @return
	 */
	protected By getLocator(String elementName, String replace1) {
		String[] locator = fetchLocatorDetails(Page, elementName).split("\\t+");
		locator[2] = locator[2].replaceFirst("\\$\\{.+?\\}", replace1);
		return getBy(locator[1], locator[2]);
	}

	/**
	 * @Function getLocator - it will fetch the value from the spec file and return
	 *           by value.
	 * @param elementName
	 * @param replace1
	 * @param replace2
	 * @return
	 */
	protected By getLocator(String elementName, String replace1, String replace2) {
		String[] locator = fetchLocatorDetails(Page, elementName).split("\\t+");
		locator[2] = locator[2].replaceFirst("\\$\\{.+?\\}", replace1);
		locator[2] = locator[2].replaceFirst("\\$\\{.+?\\}", replace2);
		return getBy(locator[1], locator[2]);
	}

	/**
	 * @Function getLocator - it will fetch the value from the spec file and return
	 *           by value.
	 * @param elementName
	 * @param replace1
	 * @param replace2
	 * @param replace2
	 * @return
	 */
	protected By getLocator(String elementName, String replace1, String replace2, String replace3) {
		String[] locator = fetchLocatorDetails(Page, elementName).split("\\t+");
		locator[2] = locator[2].replaceFirst("\\$\\{.+?\\}", replace1);
		locator[2] = locator[2].replaceFirst("\\$\\{.+?\\}", replace2);
		locator[2] = locator[2].replaceFirst("\\$\\{.+?\\}", replace3);
		return getBy(locator[1], locator[2]);
	}

	/**
	 * @Function getBy - Function will return the by value
	 * @param loctortype
	 * @param locatorvalue
	 * @return
	 */
	protected By getBy(String loctortype, String locatorvalue) {
		switch (Locators.valueOf(loctortype)) {
		case id:
			return By.id(locatorvalue);
		case xpath:
			return By.xpath(locatorvalue);
		case css:
			return By.cssSelector(locatorvalue);
		case name:
			return By.name(locatorvalue);
		case classname:
			return By.className(locatorvalue);
		case linktext:
			return By.linkText(locatorvalue);
		case partiallinkText:
			return By.partialLinkText(locatorvalue);
		default:
			return By.id(locatorvalue);
		}
	}

	/**
	 * @Function getLocatorValueFromFile - It will fetch the locator value from the
	 *           spec file.
	 * @param elementToken
	 * @return
	 */
	public String getLocatorValueFromFile(String elementToken) {
		String[] locator = fetchLocatorDetails(Page, elementToken).split("\\t+");
		return locator[2].trim();
	}

	/**
	 * @Function getLocatorValueFromFile - It will fetch the locator value from the
	 *           spec file.
	 * @param elementToken
	 * @param replace1
	 * @return
	 */
	public String getLocatorValueFromFile(String elementToken, String replace1) {
		String[] locator = fetchLocatorDetails(Page, elementToken).split("\\t+");
		locator[2] = locator[2].replaceAll("\\$\\{.+?\\}", replace1);
		return locator[2].trim();
	}

	/**
	 * @Function getLocatorValueFromFile - It will fetch the locator value from the
	 *           spec file.
	 * @param elementToken
	 * @param replace1
	 * @param replace2
	 * @return
	 */
	public String getLocatorValueFromFile(String elementToken, String replace1, String replace2) {
		String[] locator = fetchLocatorDetails(Page, elementToken).split("\\t+");
		locator[2] = locator[2].replaceFirst("\\$\\{.+?\\}", replace1);
		locator[2] = locator[2].replaceFirst("\\$\\{.+?\\}", replace2);
		return locator[2].trim();
	}

	/**
	 * @Function getLocatorValueFromFile - It will fetch the locator value from the
	 *           spec file.
	 * @param elementToken
	 * @param replace1
	 * @param replace2
	 * @param replace3
	 * @return
	 */
	public String getLocatorValueFromFile(String elementToken, String replace1, String replace2, String replace3) {
		String[] locator = fetchLocatorDetails(Page, elementToken).split("\\t+");
		locator[2] = locator[2].replaceFirst("\\$\\{.+?\\}", replace1);
		locator[2] = locator[2].replaceFirst("\\$\\{.+?\\}", replace2);
		locator[2] = locator[2].replaceFirst("\\$\\{.+?\\}", replace3);
		return locator[2].trim();
	}
}
