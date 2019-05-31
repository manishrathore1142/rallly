package com.rally.automation.utilities;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWait {

	WebDriver driver;
	WebDriverWait wait;
	int timeout;

	/**
	 * Constructor
	 * @param driver
	 * @param timeout
	 */
	public SeleniumWait(WebDriver driver, int timeout) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, timeout);
		this.timeout = timeout;
	}
	
	
	
	 public void waitForPageToLoad(){
	    	try{
		    	wait.until(new ExpectedCondition<Boolean>() {
		            public Boolean apply(WebDriver d) { 
		            	//hardWait(1);
		                return ((Boolean) ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete"));                
		            }
		        });
	    	}catch (Exception e) {  }
	    }
	 
	 public void waitTillPageLoadGetsComplete()
	 {
		 driver.manage().timeouts().setScriptTimeout(timeout, TimeUnit.SECONDS);
	 }
	
	public WebElement waitTillElementGetVisible(WebElement element) {
		return (WebElement) wait.until(ExpectedConditions.visibilityOf(element));
    }
	
	
	 public List<WebElement> waitTillElementsGetVisible(List<WebElement> elements) {
	        return (List<WebElement>) wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	    }
	    
	
}
