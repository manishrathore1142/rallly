package com.rally.automation.tests;

import static com.rally.automation.utilities.YamlReader.getYamlValue;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.rally.automation.RallyBusTestInitiator;

public class BaseTest {
	protected RallyBusTestInitiator RallyBus;
	protected String baseUrl;

	public BaseTest(String baseUrl) {
		this.baseUrl = baseUrl;
		System.out.println("baseURL::" + baseUrl);
	}

	@BeforeClass
	public void beforeMethod() {
		RallyBus = new RallyBusTestInitiator(this.getClass().getSimpleName());
		RallyBus.launchApplication(getYamlValue(baseUrl));
	}

	@BeforeMethod
	public void handleTestMethodName(Method method) {
		RallyBus.stepStartMessage(method.getName());
	}

	@AfterMethod
	public void afterMethod(ITestResult result, Method method) {
	}

	@AfterClass(alwaysRun = true)
	public void close_Test_Session() throws IOException {
		RallyBus.closeBrowserSession();
	}

}
