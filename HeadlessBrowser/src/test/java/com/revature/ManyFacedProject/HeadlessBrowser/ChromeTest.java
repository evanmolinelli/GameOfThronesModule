package com.revature.ManyFacedProject.HeadlessBrowser;

import static org.junit.Assert.assertEquals;

import java.sql.Driver;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.gargoylesoftware.htmlunit.BrowserVersion;

public class ChromeTest extends SeleniumTest{
	
	@Before
	public void setup(){
		driver = new HtmlUnitDriver(BrowserVersion.CHROME);
		driver.setJavascriptEnabled(true);
	}
	
	@Test
	@Ignore
	public void startBrowser(){
		driver.get("http://13.59.180.148:8080/index.html#/login");
		String domain = (String) driver.executeScript("return document.domain");
		System.out.println("Domain = " + domain);
		driver.findElement(By.xpath("/html/body/div/button")).click();
		driver.findElement(By.xpath("//*[@id='myModal']/div/div/div[2]"));
	}
	
	@Test
	@Ignore
	public void loginToPage(){
		driver.get("http://13.59.180.148:8080/index.html#/login");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/form/div[1]/input")).sendKeys("guy1");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/form/div[2]/input[1]")).sendKeys("guyguy123");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/form/div[2]/input[2]")).click();
		System.out.println("url = " + driver.getCurrentUrl());
	}
	
}
