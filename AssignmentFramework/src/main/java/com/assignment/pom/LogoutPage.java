
package com.assignment.pom;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.assignment.util.SeleniumUtils;

public class LogoutPage {

	private static Logger log = Logger.getLogger(LogoutPage.class.getName());
	
	@FindBy(xpath="//*[@id='userAcctTab_MainMenu']")
	static WebElement userTab;
	
	@FindBy(linkText="Sign Out")
	public static WebElement logOutLink;

	public static void logout() {
		SeleniumUtils.waitForElementToBeVisible(userTab);
		userTab.click();
		log.info("Clicked on User Account Tab.");
		logOutLink.click();
		SeleniumUtils.waitForElementToBeVisible(LoginPage.loginLink);
		Assert.assertTrue(LoginPage.loginLink.isDisplayed());
		log.info("Logged Out Successfully.");
	}
}

