package com.rally.automation.keywords;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.rally.automation.getpageobjects.GetPage;

public class TripTimingsAction extends GetPage {

	public TripTimingsAction(WebDriver driver) {
		super(driver, "TripTimingsPage");
	}

	/**
	 * select outbound depart arrive
	 */
	public void selectOutboundDepartArrive(String option) {
		wait.waitForPageToLoad();
		wait.waitTillElementGetVisible(element("select_outbound"));
		element("select_outbound").click();
		wait.waitTillElementGetVisible(element("option_outBound", option));
		clickUsingAction(element("option_outBound", option));
		logMessage("[INFO]: Able to select the value from outbound depart/arrive dropdown. " + option);
	}

	/**
	 * select return depart arrive
	 */
	public void selectReturnDepartArrive(String option) {
		wait.waitTillElementGetVisible(element("select_return"));
		element("select_return").click();
		wait.waitTillElementGetVisible(element("option_return", option));
		clickUsingAction(element("option_return", option));
		logMessage("[INFO]: Able to select the value from return depart/arrive dropdown. " + option);
	}

	/**
	 * enter trip date
	 */
	public void enterTripDate(int date, String month, int year) {
		hardWait(2);
		selectYear(year);
		selectMonth(month);
		selectDate(date);
	}

	/**
	 * it will click on outbound trip date field.
	 */
	public void clickOutboundDateField() {
		wait.waitTillElementGetVisible(element("div_outboundDateField"));
		element("div_outboundDateField").click();
		logMessage("[ACTION]: Able to click on outbound date field.");
	}

	/**
	 * it will click on return trip date field.
	 */
	public void clickReturnDateField() {
		wait.waitTillElementGetVisible(element("div_returnDateField"));
		element("div_returnDateField").click();
		logMessage("[ACTION]: Able to click on return date field.");
	}

	/**
	 * It is used to select the trip year
	 * 
	 * @param year
	 */
	public void selectYear(int year) {
		wait.waitTillElementGetVisible(element("btn_yearHeader"));
		clickUsingAction(element("btn_yearHeader"));
		wait.waitTillElementsGetVisible(elements("btn_year"));
		for (WebElement wbel : elements("btn_year")) {
			if (Integer.parseInt(wbel.getAttribute("textContent").trim()) == year) {
				wbel.click();
				logMessage("[INFO]: Able to select the year. " + year);
				break;
			}
		}
	}

	/**
	 * It is used to select the trip month
	 * 
	 * @param month
	 */
	public void selectMonth(String month) {
		wait.waitTillElementsGetVisible(elements("btn_month"));
		for (WebElement wbel : elements("btn_month")) {
			if (wbel.getAttribute("textContent").trim().equalsIgnoreCase(month)) {
				wbel.click();
				logMessage("[INFO]: Able to select the month. " + month);
				break;
			}
		}
	}

	/**
	 * It is used to select the trip date
	 * 
	 * @param date
	 */
	public void selectDate(int date) {
		wait.waitTillElementsGetVisible(elements("btn_date"));
		for (WebElement wbel : elements("btn_date")) {
			if (Integer.parseInt(wbel.getAttribute("textContent").trim()) == date) {
				wbel.click();
				logMessage("[INFO]: Able to select the date. " + date);
				break;
			}
		}
	}

	/**
	 * enter the outbound time
	 */
	public void enterOutboundTime(int hour, int minute, String period) {
		enterHour(hour, 1);
		enterMinute(minute, 1);
		enterPeriod(period, 1);
	}

	/**
	 * enter the return time
	 */
	public void enteReturnTime(int hour, int minute, String period) {
		enterHour(hour, 2);
		enterMinute(minute, 2);
		enterPeriod(period, 2);
	}

	/**
	 * enter hour
	 */
	public void enterHour(int hour, int index) {
		wait.waitTillElementGetVisible(element("div_hourHeading", String.valueOf(index)));
		clickUsingAction(element("div_hourHeading", String.valueOf(index)));
		wait.waitTillElementsGetVisible(elements("div_hour"));
		for (WebElement wbel : elements("div_hour")) {
			if (Integer.parseInt(wbel.getAttribute("textContent").trim()) == hour) {
				wbel.click();
				logMessage("[INFO]: Able to select the hour. " + hour);
				break;
			}
		}

	}

	/**
	 * enter minute
	 */
	public void enterMinute(int minute, int index) {
//		wait.waitTillElementGetVisible(element("div_minuteHeading", String.valueOf(index)));
//		clickUsingAction(element("div_minuteHeading", String.valueOf(index)));
		wait.waitTillElementsGetVisible(elements("div_minute"));
		for (WebElement wbel : elements("div_minute")) {
			if (Integer.parseInt(wbel.getAttribute("textContent").trim()) == minute) {
				wbel.click();
				logMessage("[INFO]: Able to select the minute. " + minute);
				break;
			}
		}

	}

	/**
	 * enter period
	 */
	public void enterPeriod(String period, int index) {
//		wait.waitTillElementGetVisible(element("div_periodHeading", String.valueOf(index)));
//		clickUsingAction(element("div_periodHeading", String.valueOf(index)));
		wait.waitTillElementsGetVisible(elements("div_period"));
		for (WebElement wbel : elements("div_period")) {
			if (wbel.getAttribute("textContent").trim().equalsIgnoreCase(period)) {
				wbel.click();
				logMessage("[INFO]: Able to select the Period. " + period);
				break;
			}
		}

	}

	/**
	 * click next add contact info
	 */
	public void clickNextAddContactInfo() {
		wait.waitTillElementGetVisible(element("btn_nextAddContact"));
		clickUsingAction(element("btn_nextAddContact"));
		logMessage("[ACTION]: Able to click on the add contact info.");
	}
}
