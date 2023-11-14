package com.test.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	private Properties prop;
	
	/*
	 * This  method used to load  properties file from config.properties
	 */
	public Properties init_prop() 
	{
		prop= new Properties();
		
		try {
			FileInputStream fi= new FileInputStream("src/test/resources/config/config.properties");
			
			try {
				prop.load(fi);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prop;
	}

}
