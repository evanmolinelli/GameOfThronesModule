package com.revature.ManyFacedProject.HeadlessBrowser;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.gargoylesoftware.htmlunit.BrowserVersion;

public class FirefoxTest {

	   @Test
	   public void openBlazeMeterTest() {
	       WebDriver driver = new HtmlUnitDriver(BrowserVersion.INTERNET_EXPLORER, true);
	       driver.get("http://52.14.9.154:8080/index.html");
	       driver.findElement(By.name("username"));
	       System.out.println("********************************************************");
	       System.out.println("*Passed*");
	       System.out.println("********************************************************");
	       driver.quit();
	   }
	
}

