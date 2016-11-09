package com.test;

import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EnableLiveAgent {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeTest
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "C:\\progetti\\selenium\\geckodriver.exe");
		driver = new FirefoxDriver();
		// baseUrl = "https://cs85.salesforce.com/";
		baseUrl = "https://cs85.salesforce.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testEnableLiveAgent() throws Exception {
		driver.get(baseUrl + "/");
		// driver.findElement(By.id("use_new_identity")).click();
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("Asterisc0max");
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("matteo.fiorello@mmfg.it.qasandbox");
		driver.findElement(By.id("Login")).click();
		// driver.get(baseUrl + "/home/home.jsp");
		driver.findElement(By.id("setupLink")).click();
		driver.findElement(By.id("setupSearch")).clear();
		driver.findElement(By.id("setupSearch")).sendKeys("live");
		driver.findElement(By.id("LiveAgentSettings_font")).click();
		driver.findElement(By.id("j_id0:j_id15:thePageBlock:generalSection:generalSectionItem:togglePref")).click();
		driver.findElement(By.id("j_id0:j_id15:thePageBlock:j_id25:save")).click();
		driver.findElement(By.id("j_id0:j_id15:thePageBlock:j_id25:save")).click();

	}

	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

}
