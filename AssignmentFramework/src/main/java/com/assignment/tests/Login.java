package com.assignment.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.assignment.pom.LoginPage;
import com.assignment.setup.Setup;
import com.assignment.util.PropertyFileReader;

public class Login extends Setup {

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