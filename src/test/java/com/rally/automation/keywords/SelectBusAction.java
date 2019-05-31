package com.rally.automation.keywords;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.rally.automation.getpageobjects.GetPage;

public class SelectBusAction extends GetPage {

	public SelectBusAction(WebDriver driver) {
		super(driver, "SelectBusPage");
	}

	/**
	 * 
	 * @param bustype
	 */
	public void selectBusType(String bustype) {
		wait.waitForPageToLoad();
		hardWait(12);
		boolean flag = false;
		wait.waitTillElementsGetVisible(elements("div_busType"));
		for (WebElement wbel : elements("div_busType")) {
			if (wbel.getAttribute("textContent").replaceAll("[^A-Za-z]", "").trim().equalsIgnoreCase(bustype)) {
				clickUsingAction(wbel);
				flag = true;
				logMessage("[INFO]: Able to select the bus type. " + bustype);
				break;
			}
		}
		Assert.assertTrue(flag, "[ASSERTION FAILED]: Unable to find the bus type. " + bustype);
		logMessage("[ASSERTION PASSED]: As expected able to find the bus type." + bustype);

	}

	/**
	 * click next for fund mode
	 */
	public void clickNextForFundMode() {
		wait.waitTillElementGetVisible(element("btn_nextChooseFundMode"));
		clickUsingAction(element("btn_nextChooseFundMode"));
		logMessage("[ACTION]: Able to click on the next fund mode button.");
	}

}
