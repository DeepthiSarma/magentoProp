package com.cts.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropUtils {

	public static String getValue(String string, String string2) throws IOException {
		FileInputStream file = new FileInputStream("src/test/resources/resources/data.properties");
		Properties prop = new Properties();
		prop.load(file);
		String baseUrl= prop.getProperty("url");
		
		System.out.println(baseUrl);
		return string;
	}
	
}
