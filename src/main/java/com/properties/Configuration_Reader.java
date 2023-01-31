package com.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration_Reader {

	public static Properties p;

	public Configuration_Reader() throws IOException {

		File f = new File(
				"C:\\Users\\kaaviyan\\eclipse-workspace\\Amazon_Project\\src\\main\\java\\com\\properties\\Amazon.Properties");
		FileInputStream fi = new FileInputStream(f);

		p = new Properties();
		p.load(fi);

	}

	public String getbrowser() {
		String browser = p.getProperty("browser");
		return browser;
	}

	public String geturl() {

		String url = p.getProperty("url");
		return url;
	}
	public String getpath() {

		String path = p.getProperty("path");
		return path;
	}

}
