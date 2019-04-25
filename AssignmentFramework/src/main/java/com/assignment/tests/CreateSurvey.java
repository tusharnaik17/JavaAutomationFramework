package com.assignment.tests;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.assignment.pom.CreateSurveyPage;
import com.assignment.pom.LoginPage;
import com.assignment.setup.Setup;
import com.assignment.util.LoggingListener;
import com.assignment.util.PropertyFileReader;

@Listeners(LoggingListener.class)
public class CreateSurvey extends Setup {

	@Test
	public static void createSurvey() throws IOException, InterruptedException {
		try {
			LoginPage.login(PropertyFileReader.getTestData("username"), PropertyFileReader.getTestData("password"));
			CreateSurveyPage.clickCreateSurvey();
			CreateSurveyPage.enterSurveyTitle();
			CreateSurveyPage.clickCreateSurveyButton();
			CreateSurveyPage.verifySurveyCreated();
		} catch (Exception e) {
			e.getStackTrace();
			throw e;
		}
	}
	
	@Test
	public static void verifyLogin() throws IOException, InterruptedException {
		try {
			LoginPage.login(PropertyFileReader.getTestData("username"), PropertyFileReader.getTestData("password"));
		} catch (Exception e) {
			e.getStackTrace();
			throw e;
		}
	}

}