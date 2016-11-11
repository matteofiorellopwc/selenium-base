package com.test;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class EnableLiveAgent extends AbstractBaseTest {

	@Test(groups = { "feauture1" })
	public void testEnableLiveAgent() throws Exception {
		super.doLogin();
		driver.findElement(By.id("setupLink")).click();
		driver.findElement(By.id("setupSearch")).clear();
		driver.findElement(By.id("setupSearch")).sendKeys("live");
		driver.findElement(By.id("LiveAgentSettings_font")).click();
		driver.findElement(By.id("j_id0:j_id15:thePageBlock:generalSection:generalSectionItem:togglePref")).click();
		driver.findElement(By.id("j_id0:j_id15:thePageBlock:j_id25:save")).click();
		driver.findElement(By.id("j_id0:j_id15:thePageBlock:j_id25:save")).click();

	}

}
