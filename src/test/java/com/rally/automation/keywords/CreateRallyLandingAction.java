package com.rally.automation.keywords;

import org.openqa.selenium.WebDriver;

import com.rally.automation.getpageobjects.GetPage;

public class CreateRallyLandingAction extends GetPage {

	public CreateRallyLandingAction(WebDriver driver) {
		super(driver, "CreateRallyLandingPage");
	}

	/**
	 * click to view your ride page
	 */
	public void clickToViewYourPersonalRidePage() {
		wait.waitTillPageLoadGetsComplete();
		wait.waitForPageToLoad();
		wait.waitTillElementGetVisible(element("btn_newRidePage"));
		element("btn_newRidePage").click();
		logMessage("[ACTION]: Able to click on link to view your personal ride page.");
		hardWait(10);
	}
}
