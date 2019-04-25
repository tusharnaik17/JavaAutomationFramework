package com.assignment.util;

import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.assignment.setup.Setup;

public class SeleniumUtils {

	private static Logger log = Logger.getLogger(SeleniumUtils.class.getName());

	public static void openUrl(String url) {
		Setup.driver.navigate().to(url);
		log.info("Navigated to " + url);
	}

	public static void waitForElementToBeVisible(WebElement element) {
		log.info("Waiting for element to be visible....");
		WebDriverWait wait = new WebDriverWait(Setup.driver, 60);
		wait.until(ExpectedConditions.visibilityOf(element));
		log.info("Element found");
	}

	public static void waitForElementToBeClickable(WebElement element) {
		log.info("Waiting for element to be visible....");
		WebDriverWait wait = new WebDriverWait(Setup.driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static String getCurrentUrl() {
		String currentUrl = Setup.driver.getCurrentUrl();
		return currentUrl;
	}

	public static Set<String> openUrlInNewWindow(String url) {
		((JavascriptExecutor) Setup.driver).executeScript("window.open(arguments[0])", url);
		Set<String> windowHandles = Setup.driver.getWindowHandles();
		return windowHandles;
	}

	public static void executeJavaScript(String javaScript, WebElement webElement) {
		SeleniumUtils.waitForElementToBeVisible(webElement);
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) Setup.driver;
		javascriptExecutor.executeScript(javaScript, webElement);
	}

}
