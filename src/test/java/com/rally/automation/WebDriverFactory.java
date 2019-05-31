/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rally.automation;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;

public class WebDriverFactory {

	private static String browser;


	public WebDriver getDriver(Map<String, String> seleniumconfig) {
		browser = System.getProperty("browser");
		if (browser == null || browser.isEmpty()) {
			browser = seleniumconfig.get("browser");
		}
		System.out.println("Browser=" + browser);
		Reporter.log(browser, true);
		if (seleniumconfig.get("operatingSystem").equalsIgnoreCase("window")) {
			if (browser.equalsIgnoreCase("firefox")) {
				System.out.println(seleniumconfig.get("wDriverpathFirefox"));
				return getFirefoxDriver(seleniumconfig.get("wDriverpathFirefox"), seleniumconfig.get("otherFilesPath"));
			} else if (browser.equalsIgnoreCase("chrome")) {
				System.out.println(seleniumconfig.get("wDriverpathChrome"));
				return getChromeDriver(seleniumconfig.get("wDriverpathChrome"), seleniumconfig.get("otherFilesPath"));
			} else if ((browser.equalsIgnoreCase("ie")) || (browser.equalsIgnoreCase("internetexplorer"))
					|| (browser.equalsIgnoreCase("internet explorer"))) {
				return getInternetExplorerDriver(seleniumconfig.get("wDriverpathFirefox"));
			}
		} else if (seleniumconfig.get("operatingSystem").equalsIgnoreCase("linux")) {
			if (browser.equalsIgnoreCase("firefox")) {
				System.out.println(seleniumconfig.get("driverpathFirefox"));
				return getFirefoxDriver(seleniumconfig.get("driverpathFirefox"), seleniumconfig.get("otherFilesPath"));
			} else if (browser.equalsIgnoreCase("chrome")) {
				System.out.println(seleniumconfig.get("driverpathChrome"));
				return getChromeDriver(seleniumconfig.get("driverpathChrome"), seleniumconfig.get("otherFilesPath"));
			}
		}
		return new FirefoxDriver();
	}


	private static WebDriver getChromeDriver(String driverpath, String downloadFilePath) {
		System.setProperty("webdriver.chrome.driver", driverpath);
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("download.prompt_for_download", false);
		chromePrefs.put("credentials_enable_service", false);
		chromePrefs.put("profile.password_manager_enabled", false);
		chromePrefs.put("plugins.plugins_disabled",
				new String[] { "Adobe Flash Player", "Chrome PDF Viewer", "plugins.always_open_pdf_externally" });
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory",
				System.getProperty("user.dir") + File.separator + downloadFilePath);
		chromePrefs.put("credentials_enable_service", false);
		chromePrefs.put("profile.password_manager_enabled", false);
		options.setExperimentalOption("prefs", chromePrefs);
		options.addArguments("--disable-extensions");
		options.addArguments("test-type");
		options.addArguments("--disable-impl-side-painting");
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		options.setCapability(ChromeOptions.CAPABILITY, options);
		options.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().deleteAllCookies();
		return driver;
	}

	private static WebDriver getInternetExplorerDriver(String driverpath) {
		System.setProperty("webdriver.ie.driver", driverpath);
		InternetExplorerOptions expectedInternetExplorerOptions = new InternetExplorerOptions();
		expectedInternetExplorerOptions.setCapability("requireWindowFocus", true);  
		expectedInternetExplorerOptions.setCapability("ignoreZoomSetting", true);
		expectedInternetExplorerOptions.setCapability("ignoreZoomLevel", true);
		expectedInternetExplorerOptions.setCapability("ie.ensureCleanSession", true);
		expectedInternetExplorerOptions.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		expectedInternetExplorerOptions.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, true);
		expectedInternetExplorerOptions.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
		WebDriver driver = new InternetExplorerDriver(expectedInternetExplorerOptions);
		driver.manage().deleteAllCookies();
		return driver;
	}




	private static WebDriver getFirefoxDriver(String driverpath, String downloadFilePath) {
		FirefoxProfile profile = new FirefoxProfile();
		System.setProperty("webdriver.gecko.driver", driverpath);
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		profile.setPreference("browser.cache.disk.enable", false);
//  	  profile.setPreference("browser.startup.homepage_override.mstone", "ignore");
//  	  profile.setPreference("startup.homepage_welcome_url.additional", "about:blank");
//  	  profile.setPreference("browser.download.useDownloadDir", true);
//  	  profile.setPreference("browser.download.folderList", 2);
//  	  profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
//  	  profile.setPreference("security.mixed_content.block_active_content", true);
//  	  profile.setPreference("security.mixed_content.block_display_content", false);
//
//  	  profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
//  	    "application/msword, application/csv, application/ris, text/csv, application/pdf, text/plain, application/zip, application/x-zip, application/x-zip-compressed, application/download, application/octet-stream");
//  	  profile.setPreference("browser.download.manager.showWhenStarting", false);
//  	  profile.setPreference("browser.download.manager.focusWhenStarting", false);
		profile.setPreference("browser.download.dir",
				System.getProperty("user.dir") + File.separator + downloadFilePath);
//
//  	  profile.setPreference("browser.download.manager.showAlertOnComplete", false);
//  	  profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
//  	  profile.setPreference("plugin.disable_full_page_plugin_for_types",
//  	    "application/pdf,application/vnd.adobe.xfdf,application/vnd.fdf,application/vnd.adobe.xdp+xml");
//  	  profile.setPreference("pdfjs.disabled", true);
		// FirefoxOptions options = new
		// FirefoxOptions().setProfile(profile).addCapabilities(capabilities);
		return new FirefoxDriver();

	}
}
