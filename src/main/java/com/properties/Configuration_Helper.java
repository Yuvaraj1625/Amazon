package com.properties;

import java.io.IOException;

public class Configuration_Helper {
	
	private Configuration_Helper() {
	}
	
	
	public static Configuration_Reader getInstanceCR() throws IOException {

		Configuration_Reader cr=new Configuration_Reader();
		return cr;
	}
	
	
	

}
