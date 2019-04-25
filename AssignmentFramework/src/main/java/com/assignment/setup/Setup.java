package com.assignment.setup;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.assignment.pom.CreateSurveyPage;
import com.assignment.pom.LoginPage;
import com.assignment.pom.LogoutPage;
import com.assignment.util.CommonUtils;
import com.assignment.util.PropertyFileReader;

public class Setup {

	public static WebDriver driver;
	public static int i = 1;
	private static Logger log = Logger.getLogger(Setup.class.getName());
	public static Properties testData = null;
	public static Properties config = null;
	private static String configPropertiesFilePath = ".\\src\\main\\resources\\properties\\config.properties";
	public static String testDataPropertiesFilePath = ".\\src\\main\\resources\\properties\\testData.properties";
	
	
	@BeforeSuite(alwaysRun = true)
	public void testBedSetup() throws Exception {
		
		// load properties files
		config = PropertyFileReader.loadPropertiesFile(configPropertiesFilePath);
		testData = PropertyFileReader.loadPropertiesFile(testDataPropertiesFilePath);
	}

	@AfterSuite(alwaysRun = true)
	public void testBedTearDown() throws Exception {
		try {
	//		driver.quit();
			log.info("Closed browser");
		} catch (Exception e) {
			log.info("Browser is already closed by test method");
		}
	}

	@BeforeMethod(alwaysRun = true)
	public static void driverInitialization() throws IOException {
		log.info("\n");
		log.info("**********************************************");
		log.info("Executing Test Case Number: " + i++);
		driver = Driver.getDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(CommonUtils.getURL());

		// Initialize PageFactory classes

		PageFactory.initElements(driver, LoginPage.class);
		PageFactory.initElements(driver, CreateSurveyPage.class);
		PageFactory.initElements(driver, LogoutPage.class);
	
	}

	@AfterMethod(alwaysRun = true)
	public static void testTearDown() {
	//	driver.close();
		log.info("Closed browser");
	}

}