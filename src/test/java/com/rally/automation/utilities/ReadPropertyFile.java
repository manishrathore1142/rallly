package com.rally.automation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class ReadPropertyFile {

	private static String defaultPropFilePath = System.getProperty("user.dir") + "src" + File.separator + "test"
			+ File.separator + "resources" + File.separator + "testdata" + File.separator + "Data.properties";

	/**
	 * @Function readConfigPropFile - Read data from the config file.
	 * @File config file - it holds the basic information like driver path, timeout,
	 *       browser details. which are required for execution or framework setup.
	 * 
	 * @param sPath
	 * @param sProperty
	 * @return property value
	 */
	public static String readConfigPropFile(String sPath, String sProperty) {
		Properties propRead = new Properties();
		try {
			propRead.load(new FileInputStream(new File(System.getProperty("user.dir") + File.separator+sPath)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return propRead.getProperty(sProperty);
	}

	/**
	 * @Function readDataSharedPropFile - It will read the data from the shared
	 *           property file.
	 * @param sKey
	 * @return
	 */
	public static String readDataSharedPropFile(String sKey) {
		Properties propRead = new Properties();
		try {
			propRead.load(new FileInputStream(defaultPropFilePath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return propRead.getProperty(sKey);
	}

	/**
	 * @Function writeDataSharedPropFile - It will write the data on the shared
	 *           property file.
	 * @param sKey
	 * @param sValue
	 */
	public static void writeDataSharedPropFile(String sKey, String sValue) {
		Properties props;
		try {
			if (!(sValue.equals(null) || sValue.equals(""))) {
				props = new Properties();
				InputStream inPropFile = new FileInputStream(defaultPropFilePath);
				props.load(inPropFile);
				inPropFile.close();
				OutputStream outPropFile = new FileOutputStream(defaultPropFilePath);
				props.setProperty(sKey, sValue);
				props.store(outPropFile, null);
				outPropFile.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
