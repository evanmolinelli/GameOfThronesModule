package com.revature.ManyFacedProject.HeadlessBrowser;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PhantomJSTest {

	@Test
	@Ignore
	public void phantomTest(){
//		 File file = new File("C:/phantomjs/phantomjs-2.1.1-windows/bin/phantomjs.exe");
		DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "C:/phantomjs/phantomjs-2.1.1-windows/bin/phantomjs.exe" );
         WebDriver driver = new PhantomJSDriver(caps);
 		driver.get("http://13.59.180.148:8080/index.html#/login");
 		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/form/div[1]/input")).sendKeys("guy1");
 		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/form/div[2]/input[1]")).sendKeys("guyguy123");
 		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/form/div[2]/input[2]")).click();
 		System.out.println("url = " + driver.getCurrentUrl());
 		
 		driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-9']/ul[2]/li[1]/a"));
 		driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-9\"]/ul[2]/li[1]/a"));
	}
}
