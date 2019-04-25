package com.assignment.util;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;

public class CommonUtils {

	private static Logger log = Logger.getLogger(CommonUtils.class.getName());

	public static String getURL() throws IOException {
		String url = null;
		if (PropertyFileReader.getConfigValue("Env").equalsIgnoreCase("qa")) {
			url = PropertyFileReader.getConfigValue("applicationURL-QA").toString();
		} else if (System.getProperty("Env").equalsIgnoreCase("uat")) {
			url = PropertyFileReader.getConfigValue("applicationURL-UAT").toString();
		} else {
			url = PropertyFileReader.getConfigValue("applicationURL-PROD").toString();
		}
		return url;
	}

	public static String getChromeDriverPath() {
		Path chromeDriverPath;
		if (System.getProperty("os.name").startsWith("Mac")) {
			chromeDriverPath = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "driver",
					"chromedriver_mac64", "chromedriver");
		} else {
			chromeDriverPath = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "driver",
					"chromedriver.exe");
		}
		return chromeDriverPath.toString();
	}

	public static String getCurrentTimeForScreenShot() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MMM_yyyy_hh-mm-ss_aaa(zzz)");
		java.util.Date curDate = new java.util.Date();
		String strDate = sdf.format(curDate);
		String strActDate = strDate.toString();
		return strActDate;
	}
}