package com.rally.automation.keywords;

import org.openqa.selenium.WebDriver;

import com.rally.automation.getpageobjects.GetPage;

public class CreateRallyAction extends GetPage{

	public CreateRallyAction(WebDriver driver) {
		super(driver, "CreateRallyPage");
	}

	/**
	 * click final create rally
	 */
	public void clickFinalToCreateRally() {
		wait.waitTillPageLoadGetsComplete();
		wait.waitForPageToLoad();
		wait.waitTillElementGetVisible(element("btn_finalCreateRally"));
		clickUsingAction(element("btn_finalCreateRally"));
		logMessage("[ACTION]: Able to click on the final to create rally.");
	}
}
