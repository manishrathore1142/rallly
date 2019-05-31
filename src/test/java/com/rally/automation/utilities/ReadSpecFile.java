package com.rally.automation.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadSpecFile {

	private static String defaultBaseSpecFilePath = System.getProperty("user.dir") + File.separator + "src"
			+ File.separator + "test" + File.separator + "resources" + File.separator + "PageObjectRepository";

	/**
	 * @Function
	 * fetchLocatorDetails - it will fetch the locator details from the spec file.
	 * @param PageName
	 * @param LocatorName
	 * @return
	 */
	public static String fetchLocatorDetails(String PageName, String LocatorName) {
		File specFile = new File(defaultBaseSpecFilePath + File.separator + PageName + ".spec");
		String line = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(specFile));
			while ((line = br.readLine()) != null) {
				if (line.matches(LocatorName+"\\t+.*"))
					break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return line;
	}
	
	
	
}
