/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rally.automation;

import static com.rally.automation.utilities.ReadPropertyFile.readConfigPropFile;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class TestSessionInitiator {

	protected WebDriver driver, originalDriver;
	private WebDriverFactory wdfactory;
	Map<String, Object> chromeOptions = null;
	protected static String product;

	public TestSessionInitiator() {
		wdfactory = new WebDriverFactory();
	}

	protected void configureBrowser() {
		driver = wdfactory.getDriver(getSessionConfig());
		driver.manage().window().maximize();
		int timeout;
		timeout = Integer.parseInt(getSessionConfig().get("timeout"));
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(timeout, TimeUnit.SECONDS);
	}

	private static Map<String, String> getSessionConfig() {
		String[] configKeys = { "tier", "browser", "timeout", "operatingSystem", "wDriverpathIE", "wDriverpathChrome",
				"wDriverpathFirefox", "driverpathFirefox", "driverpathChrome", "otherFilesPath", "screenshot-path" };
		Map<String, String> config = new HashMap<String, String>();
		for (String string : configKeys) {
			config.put(string, readConfigPropFile("Config.properties", string));
		}
		return config;
	}

	public static String getEnv() {
		String tier = System.getProperty("env");
		if (tier == null)
			tier = getSessionConfig().get("tier");
		return tier;
	}

	public static String getBrowser() {
		String browser = System.getProperty("browser");
		if (browser == null)
			browser = getSessionConfig().get("browser");
		return browser;
	}

	public String getTakeScreenshot() {
		return getSessionConfig().get("takeScreenshot");
	}

	public static String getProduct() {
		if (System.getProperty("product") != null)
			product = System.getProperty("product");
		return product;
	}

	public void launchApplication(String applicationpath) {
		Reporter.log("The application url is :- " + applicationpath, true);
		Reporter.log("The test browser is :- " + getBrowser(), true);
		driver.get(applicationpath);
	}

	public void getURL(String url) {
		driver.manage().deleteAllCookies();
		driver.get(url);
	}

	public String getCurrentWindowsURL() {
		return driver.getCurrentUrl().trim();
	}

	public void closeBrowserSession() {
		driver.quit();
	}

	public void stepStartMessage(String testStepName) {
		Reporter.log(" ", true);
		Reporter.log("***** STARTING TEST STEP:- " + testStepName.toUpperCase() + " *****", true);
		Reporter.log(" ", true);
	}

	public void waitForPageLoad() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}

	public void refreshPage() {
		driver.navigate().refresh();
	}

	public void navigateBack() {
		driver.navigate().back();
	}

	public void printMethodExecutionTime(long startTime, long endTime) {
		long totalExecutionTimeInSeconds = (endTime - startTime) / 1000;
		long hours = totalExecutionTimeInSeconds / 3600;
		long minutes = (totalExecutionTimeInSeconds % 3600) / 60;
		long seconds = totalExecutionTimeInSeconds % 60;

		String timeString = String.format("%02d:%02d:%02d", hours, minutes, seconds);
		Reporter.log("\n---------- METHOD EXECUTION TIME: " + timeString + " ----------\n", true);
	}

	public void closeWindow() {
		driver.close();
	}

	public void clearBrowserSession() {
		driver.manage().deleteAllCookies();
	}

}
