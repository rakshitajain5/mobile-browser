package com.android.qtpselenium;

import java.io.File;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;


/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		WebDriver mobWebDriver = null;
		DesiredCapabilities capabilities = DesiredCapabilities.android();
		capabilities.setCapability("deviceName", "Samsung");
		capabilities.setCapability("platformName", "android");
		// capabilities.setCapability(CapabilityType.VERSION, osVersion);
		capabilities.setCapability("app",
				"Chrome");
		capabilities.setCapability("udid", "4df7e18f440c30c9");
		capabilities.setCapability("autoAcceptAlerts", true);
		try {
			mobWebDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
					capabilities);
			System.out.println("initialised driver");
			mobWebDriver.manage().timeouts()
			.implicitlyWait(10, TimeUnit.SECONDS);
			mobWebDriver.manage().timeouts()
			.pageLoadTimeout(60, TimeUnit.SECONDS);
			
			mobWebDriver.get("http://google.com");
			/*mobWebDriver.findElement(By.name("q")).sendKeys(
					"Appium Meetup Noida");
			mobWebDriver.findElement(By.xpath("//button[@type='submit']"))
			.click();*/
			mobWebDriver.manage().timeouts()
			.implicitlyWait(10, TimeUnit.SECONDS);
			System.out.println("click download");
			mobWebDriver.findElement(By.xpath("//*[@id='body']/div[1]/form/button")).click();
			System.out.println("download started");
			mobWebDriver.manage().timeouts()
			.implicitlyWait(10, TimeUnit.SECONDS);
			
			 boolean boolFound = false;
			 try
	           {
	             Alert alert = mobWebDriver.switchTo().alert();
	             if (alert != null)
	             {
	               alert.accept();
	               boolFound = true;
	               System.out.println("SUCCESS");
	             }
	           }
	           catch (NoAlertPresentException ex) {
	        	   System.out.println("#######################" + ex + "#####################");
	           }

			
			
			//mobWebDriver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'button_primary') and @text='OK']")).click();
					
		} catch (Exception e) {
			System.out.println("in error-------------" + e);
			e.printStackTrace();
		} finally {
			mobWebDriver.close();
			mobWebDriver.quit();
		}

	}
}
