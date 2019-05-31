package com.rally.automation.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RallyBus_TC01_CreateOwnRide extends BaseTest {

	public RallyBus_TC01_CreateOwnRide(String baseUrl) {
		super("ApplicationURL");
	}

	String sTimeStamp;

	@BeforeClass
	public void init() {

		// Time Stamp
		sTimeStamp = String.valueOf(System.currentTimeMillis());

	}

	@Test
	public void TestStep01_CreateSearchRide() {
		RallyBus.createSearchRide.clickCreateOwnDestinationLink();
	}

	@Test
	public void TestStep02_SelectRoute() {
		RallyBus.selectRoute.enterRallySourceDetails("Linkedin");
		RallyBus.selectRoute
				.selectFromSuggestionList("LinkedIn Corporation, North Mathilda Avenue, Sunnyvale, CA, USA");
		RallyBus.selectRoute.verifyNextAddTimeEnable();
		RallyBus.selectRoute.clickAddRallyPoint();
		RallyBus.selectRoute.enterNewRallyPoint("Test");
		RallyBus.selectRoute.selectFromSuggestionList("Testarossa Winery, College Avenue, Los Gatos, CA, USA");
		RallyBus.selectRoute.enterRallyDestinationDetails("Facebook");
		RallyBus.selectRoute.selectFromSuggestionList("Facebook, Hacker Way, Menlo Park, CA, USA");
		RallyBus.selectRoute.clickNextForAddTiming();
	}

	@Test
	public void TestStep03_TripTiming() {
		RallyBus.tripTiming.selectOutboundDepartArrive("Depart On");
		RallyBus.tripTiming.clickOutboundDateField();
		RallyBus.tripTiming.enterTripDate(31, "May", 2019);
		RallyBus.tripTiming.enterOutboundTime(10, 30, "AM");
		RallyBus.tripTiming.selectReturnDepartArrive("Depart On");
		RallyBus.tripTiming.clickReturnDateField();
		RallyBus.tripTiming.enterTripDate(31, "May", 2019);
		RallyBus.tripTiming.enteReturnTime(10, 45, "PM");
		RallyBus.tripTiming.clickNextAddContactInfo();
	}

	//@Test
	public void TestStep04_ContactInfo() {
		RallyBus.contactInfo.enterRiderName("AutomationTest" + sTimeStamp);
		RallyBus.contactInfo.enterRiderEmail(sTimeStamp + "@xyz.com");
		RallyBus.contactInfo.enterRiderPhoneNumber("7897978789");
		RallyBus.contactInfo.clickNextForSelectBus();
	}

	//@Test
	public void TestStep05_SelectBus() {
		RallyBus.selectBus.selectBusType("Motorcoach");
		RallyBus.selectBus.clickNextForFundMode();
	}

	//@Test
	public void TestStep06_SelectFundingMode() {
		// RallyBus.selectFundingMode.setSliderValueToZero();
		RallyBus.selectFundingMode.enterNumberOfRider("29");
		RallyBus.selectFundingMode.clickNextForReview();
	}

	//@Test
	public void TestStep07_ReviewCreateRally() {
		RallyBus.createRally.clickFinalToCreateRally();
	}

	//@Test
	public void TestStep08_NavigateToYourRidePage() {
		RallyBus.createRallyLanding.clickToViewYourPersonalRidePage();
	}
}