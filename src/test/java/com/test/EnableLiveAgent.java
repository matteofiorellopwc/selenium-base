package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class EnableLiveAgent extends AbstractBaseTest {

	@Test(groups = { "feauture1" })
	@Parameters({ "param", "param2" })
	public void testEnableLiveAgent(String param, String param2) throws Exception {
		super.doLogin();
		System.out.println("Test parameter1 " + param);
		System.out.println("Test parameter2 " + param2);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("userNavLabel"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Setup"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("setupSearch"))).clear();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("setupSearch"))).sendKeys("live");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("LiveAgentSettings_font"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.id("j_id0:j_id15:thePageBlock:generalSection:generalSectionItem:togglePref")))
				.click();
		driver.findElement(By.id("j_id0:j_id15:thePageBlock:j_id25:save")).click();
		driver.findElement(By.id("j_id0:j_id15:thePageBlock:j_id25:save")).click();

	}

}
