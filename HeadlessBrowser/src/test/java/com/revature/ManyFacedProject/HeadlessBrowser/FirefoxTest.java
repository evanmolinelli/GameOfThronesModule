package com.revature.ManyFacedProject.HeadlessBrowser;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxTest {

	   @Test
	   public void openBlazeMeterTest() {
	       FirefoxDriver driver = new FirefoxDriver();
	       driver.get("http://blazemeter.com");
	       WebElement title = driver.findElement(By.xpath("//title"));
	       System.out.println("********************************************************");
	       System.out.println("*" + title.getAttribute("text") + "*");
	       System.out.println("********************************************************");
	       driver.quit();
	   }
	
}

