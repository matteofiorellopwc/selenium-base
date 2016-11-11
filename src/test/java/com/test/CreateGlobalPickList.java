package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class CreateGlobalPickList extends AbstractBaseTest {

	@Test(groups = { "feauture2" })
	public void testCreateGlobalPickList() throws Exception {
		super.doLogin();
		WebDriverWait wait = new WebDriverWait(driver, 10);

		driver.findElement(By.linkText("Home")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.id("userNavLabel"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Setup"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("setupSearch"))).clear();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("setupSearch"))).sendKeys("pick");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("Picklists_font"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.name("new"))).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.id("MasterLabel"))).clear();
		driver.findElement(By.id("MasterLabel")).sendKeys("Brand");
		driver.findElement(By.id("DeveloperName")).clear();
		driver.findElement(By.id("DeveloperName")).sendKeys("Brand");
		driver.findElement(By.id("Description")).click();
		driver.findElement(By.id("ptext")).clear();
		driver.findElement(By.id("ptext")).sendKeys(
				"MaxMara\nSportmax\nWeekend MaxMara\nMax&Co.\nMarella\niBlues\nPennyBlack\nMarina Rinaldi\nPersona\nDiffusione Tessile");
		driver.findElement(By.cssSelector("#bottomButtonRow > input[name=\"save\"]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Back to List"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.name("new"))).click();

		driver.findElement(By.id("MasterLabel")).clear();
		driver.findElement(By.id("MasterLabel")).sendKeys("Language");
		driver.findElement(By.id("DeveloperName")).clear();
		driver.findElement(By.id("DeveloperName")).sendKeys("Language");
		driver.findElement(By.id("Description")).click();
		driver.findElement(By.id("ptext")).clear();
		driver.findElement(By.id("ptext")).sendKeys("IT\nEN\nDE\nES\nFR\nRU\nJP\nCN");
		driver.findElement(By.cssSelector("#bottomButtonRow > input[name=\"save\"]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Back to List"))).click();
	}

}
