package com.test;

import static org.testng.Assert.fail;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.pwc.utils.TestUtils;

public abstract class AbstractBaseTest {

	protected WebDriver driver;
	protected String baseUrl = TestUtils.getProperties().getProperty("selenium.test.base.url");;
	protected boolean acceptNextAlert = true;
	protected StringBuffer verificationErrors = new StringBuffer();
	private static Properties prop = null;
	private static final Logger logger = LoggerFactory.getLogger(AbstractBaseTest.class);
	private static final String systemPropertyDriver = TestUtils.getProperties()
			.getProperty("selenium.system.property.driver");
	private static final String systemPropertyDriverPath = TestUtils.getProperties()
			.getProperty("selenium.system.property.driver.path");
	private static final String loginPasswd = TestUtils.getProperties().getProperty("salesforce.user.passwd");
	private static final String user = TestUtils.getProperties().getProperty("salesforce.user");

	@BeforeTest
	public void setUp() throws Exception {
		System.setProperty(systemPropertyDriver, systemPropertyDriverPath);
		// driver = new FirefoxDriver();
		// driver = new HtmlUnitDriver();
		driver = new HtmlUnitDriver(true);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void doLogin() {
		driver.get(baseUrl + "/");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(loginPasswd);
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(user);
		driver.findElement(By.id("Login")).click();
	}

	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	public Properties getProperties() {
		if (prop == null) {
			prop = new Properties();
			InputStream stream = getClass().getResourceAsStream("/env.properties");
			try {
				prop.load(stream);
			} catch (IOException e) {
				logger.error(e.getMessage(), e);
			}
		}
		return prop;

	}

}
