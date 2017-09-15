package com.revature.ManyFacedProject.HeadlessBrowser;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


public class SeleniumTest {
	
	protected static HtmlUnitDriver driver;
	protected static String URL;

	public HtmlUnitDriver getDriver() {
		return driver;
	}

	public void setDriver(HtmlUnitDriver driver) {
		SeleniumTest.driver = driver;
	}
	 
}
