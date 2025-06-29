package org.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	public static void main(String[] args) {

	   Properties props = new Properties();

       try (FileInputStream fis = new FileInputStream("config.properties")) {
           props.load(fis);

           // Example: reading specific properties
           String browser = props.getProperty("browser");
           String url = props.getProperty("url");

           System.out.println("Browser: " + browser);
           System.out.println("URL: " + url);
       } catch (IOException e) {
           System.err.println("Error reading config.properties: " + e.getMessage());
       }
   }

}
