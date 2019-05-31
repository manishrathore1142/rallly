package com.rally.automation.keywords;

import org.openqa.selenium.WebDriver;

import com.rally.automation.getpageobjects.GetPage;

public class CreateSearchRideAction extends GetPage{

	public CreateSearchRideAction(WebDriver driver) {
		super(driver, "CreateSearchRidePage");
	}

	/**
	 * click create own destination
	 */
	public void clickCreateOwnDestinationLink()
	{
		hardWait(1);
		wait.waitTillElementGetVisible(element("btn_ownDest"));
		if(elements("btn_ownDest").size() > 0) {
		clickUsingAction(element("btn_ownDest"));
		logMessage("[ACTIONS]: Able to click on the Create Own Destination Link.");}
	}
	
	
}
