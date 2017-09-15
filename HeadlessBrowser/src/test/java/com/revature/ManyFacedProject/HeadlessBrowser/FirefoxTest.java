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
	       driver.get("http://http://52.14.9.154:8080/index.html");
	       WebElement title = driver.findElement(By.xpath("//title"));
	       System.out.println("********************************************************");
	       System.out.println("*" + title.getAttribute("text") + "*");
	       System.out.println("********************************************************");
	       driver.quit();
	   }
	
}

