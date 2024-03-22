package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFiles {
	public static void main(String[] args) throws IOException {
		// Open the document in java readable format
		FileInputStream fils = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		// Create object of properties class from java.util
		Properties p = new Properties();
		// load the document to properties class
		p.load(fils);
		// provide the key and fetch the value
		String value = p.getProperty("username");

		System.out.println(value);

		String value1 = p.getProperty("url");

		System.out.println(value1);

		String value2 = p.getProperty("password");

		System.out.println(value2);

	}
}
