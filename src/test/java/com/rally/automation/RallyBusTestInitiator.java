package com.rally.automation;

import com.rally.automation.keywords.ContactInfoAction;
import com.rally.automation.keywords.CreateRallyAction;
import com.rally.automation.keywords.CreateRallyLandingAction;
import com.rally.automation.keywords.CreateSearchRideAction;
import com.rally.automation.keywords.SelectBusAction;
import com.rally.automation.keywords.SelectFundingModeAction;
import com.rally.automation.keywords.SelectRouteAction;
import com.rally.automation.keywords.TripTimingsAction;

public class RallyBusTestInitiator extends TestSessionInitiator {

	public CreateSearchRideAction createSearchRide;
	public SelectRouteAction selectRoute;
	public TripTimingsAction tripTiming;
	public ContactInfoAction contactInfo;
	public SelectBusAction selectBus;
	public SelectFundingModeAction selectFundingMode;
	public CreateRallyAction createRally;
	public CreateRallyLandingAction createRallyLanding;
	
	private void initPage() {

		createSearchRide = new CreateSearchRideAction(driver);
		selectRoute = new SelectRouteAction(driver);
		tripTiming = new TripTimingsAction(driver);
		contactInfo = new ContactInfoAction(driver);
		selectBus = new SelectBusAction(driver);
		selectFundingMode = new SelectFundingModeAction(driver);
		createRally = new CreateRallyAction(driver);
		createRallyLanding =  new CreateRallyLandingAction(driver);
	}

	public RallyBusTestInitiator(String testname) {
		super();
		configureBrowser();
		initPage();
	}

}
