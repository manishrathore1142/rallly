package com.rally.automation.keywords;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;

import com.rally.automation.getpageobjects.GetPage;

public class SelectFundingModeAction extends GetPage {

	public SelectFundingModeAction(WebDriver driver) {
		super(driver, "SelectFundingModePage");
	}

	/**
	 * 
	 */
	public void setSliderValueToZero() {
			Actions act = new Actions(driver);
			act.moveToElement(element("inp_ridersNum")).sendKeys(Keys.HOME).build().perform();
		logMessage("[INFO]: Able to set the rider count to zero.");
	}

	/**
	 * 
	 * @param num
	 */
	public void enterNumberOfRider(String num) {
		wait.waitTillPageLoadGetsComplete();
		wait.waitForPageToLoad();
		//hardWait(7);
		Actions act = new Actions(driver);
		String count;
		wait.waitTillElementGetVisible(element("inp_ridersNum"));
		count = element("inp_ridersNum").getAttribute("value").trim();
		while(!count.equalsIgnoreCase(num)) {
		wait.waitTillElementGetVisible(element("inp_ridersNum"));
		//act.moveToElement(element("inp_ridersNum"),10, 0).sendKeys(Keys.ARROW_RIGHT).build().perform();
		act.dragAndDropBy(element("inp_ridersNum"),10, 0).build().perform();
		//act.moveToElement(element("inp_ridersNum")).clickAndHold().sendKeys(Keys.chord(Keys.SHIFT,Keys.ARROW_RIGHT)).build().perform();
		count = element("inp_ridersNum").getAttribute("value").trim();
		}
		logMessage("[INFO]: Able to update the number of riders." + num);
	}

	/**
	 * click next for review
	 */
	public void clickNextForReview() {
		wait.waitTillElementGetVisible(element("btn_nextReview"));
		clickUsingAction(element("btn_nextReview"));
		logMessage("[ACTION]: Able to click on the next review button.");
	}
}
