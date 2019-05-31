package com.rally.automation.keywords;

import org.openqa.selenium.WebDriver;

import com.rally.automation.getpageobjects.GetPage;

public class ContactInfoAction extends GetPage {

	public ContactInfoAction(WebDriver driver) {
		super(driver, "ContactInfoPage");
	}

	/**
	 * function will enter the rider name
	 * 
	 * @param name
	 */
	public void enterRiderName(String name) {
		wait.waitTillElementGetVisible(element("inp_rallyName"));
		enterTextUsingAction(element("inp_rallyName"), name);
		logMessage("[INFO]: Able to enter the rider name. " + name);
	}

	/**
	 * function will enter the rider email
	 * 
	 * @param email
	 */
	public void enterRiderEmail(String email) {
		hardWait(4);
		wait.waitForPageToLoad();
		wait.waitTillElementGetVisible(element("inp_rallyEmail"));
		enterTextUsingAction(element("inp_rallyEmail"),email);
		logMessage("[INFO]: Able to enter the rider email. " + email);
	}

	/**
	 * function will enter the rider phone
	 * 
	 * @param phone
	 */
	public void enterRiderPhoneNumber(String phone) {
		wait.waitForPageToLoad();
		hardWait(8);
		wait.waitTillElementGetVisible(element("inp_rallyPhone"));
		enterTextUsingAction(element("inp_rallyPhone"),phone);
		logMessage("[INFO]: Able to enter the rider pnone number. " + phone);
	}

	/**
	 * click next select Bus
	 */
	public void clickNextForSelectBus() {
		wait.waitTillElementGetVisible(element("btn_nextSelectBus"));
		clickUsingAction(element("btn_nextSelectBus"));
		logMessage("[ACTION]: Able to click on the next select bus button.");
	}

}
