package com.assignment.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.assignment.pom.LoginPage;
import com.assignment.pom.LogoutPage;
import com.assignment.setup.Setup;
import com.assignment.util.PropertyFileReader;

public class Logout extends Setup{

	
	@Test
	public static void verifyLogout() throws IOException, InterruptedException {
		try {
			LoginPage.login(PropertyFileReader.getTestData("username"), PropertyFileReader.getTestData("password"));
			LogoutPage.logout();
		} catch (Exception e) {
			e.getStackTrace();
			throw e;
		}
	}
}
