package com.rally.automation.keywords;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.rally.automation.getpageobjects.GetPage;

public class SelectRouteAction extends GetPage {

	public SelectRouteAction(WebDriver driver) {
		super(driver, "SelectRoutePage");
	}

	/**
	 * enter source Name
	 */
	public void enterRallySourceDetails(String Source) {
		hardWait(2);
		wait.waitTillPageLoadGetsComplete();
		wait.waitTillElementGetVisible(element("inp_rallyFrom"));
		enterTextUsingAction(element("inp_rallyFrom"), Source);
		enterTextUsingAction(element("inp_rallyFrom"), " ");
		logMessage("[INFO]: Able to enter the source information. " + Source);
	}

	/**
	 * enter destination Name
	 */
	public void enterRallyDestinationDetails(String Dest) {
		wait.waitTillElementGetVisible(element("inp_rallyTo"));
		enterTextUsingAction(element("inp_rallyTo"), Dest);
		enterTextUsingAction(element("inp_rallyTo"), " ");
		logMessage("[INFO]: Able to enter the destination information. " + Dest);
	}

	/**
	 * select from suggestion
	 */
	public boolean selectFromSuggestionList(String option) {
		hardWait(5);
		wait.waitTillElementsGetVisible(elements("div_locOptions"));
		boolean flag = false;
		if (elements("div_locOptions").size() > 0) {
			for (WebElement wbel : elements("div_locOptions")) {
				if (wbel.getAttribute("textContent").trim().replaceAll(" |,", "")
						.equalsIgnoreCase(option.replaceAll(" |,", ""))) {
					clickUsingAction(wbel);
					flag = true;
					break;
				}
			}
		}
		return flag;
	}

	/**
	 * verify whether next add time
	 */
	public void verifyNextAddTimeEnable() {
		hardWait(2);
		wait.waitTillElementGetVisible(element("btn_nextAddTime"));
		if (element("btn_nextAddTime").getAttribute("disabled") == null)
			logMessage("[INFO]: As expected next add time button is enabled");
	}

	/**
	 * click add rally point
	 */
	public void clickAddRallyPoint() {
		wait.waitTillElementGetVisible(element("div_addRallyPoint"));
		element("div_addRallyPoint").click();
		logMessage("[ACTION]: Able to click add rally point link.");
	}

	/**
	 * enter new rally point
	 */
	public void enterNewRallyPoint(String newSource) {
		Actions act = new Actions(driver);
		wait.waitTillElementsGetVisible(elements("inp_newPickUpPoint"));
		int size = elements("inp_newPickUpPoint").size();
		act.clickAndHold(elements("inp_newPickUpPoint").get(size - 1)).sendKeys(Keys.chord(Keys.CONTROL, "a"),newSource).build()
				.perform();
		//act.moveToElement(elements("inp_newPickUpPoint").get(size - 1)).sendKeys(newSource).build().perform();
		logMessage("[INFO]: Able to enter the new source point. " + newSource);
	}

	/**
	 * remove last rally point
	 */
	public void removeLastRallyPoint() {
		wait.waitTillElementsGetVisible(elements("img_closeNewPickUpPoint"));
		int size = elements("img_closeNewPickUpPoint").size();
		elements("img_closeNewPickUpPoint").get(size - 1).click();
		logMessage("[ACTION]: Able to remove last rally point.");
	}

	/**
	 * click next for add time
	 */
	public void clickNextForAddTiming() {
		wait.waitTillElementGetVisible(element("btn_nextAddTime"));
		clickUsingAction(element("btn_nextAddTime"));
		logMessage("[ACTION]: Able to click on the next add time button.");
	}

}
