package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadData {
public static void main(String[] args) throws IOException {
	
	FileInputStream fil = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
	
	Properties p = new Properties();
	
	p.load(fil);
	
	String name = p.getProperty("username");
	
	System.out.println(name);
	
	String url = p.getProperty("url");
	
	System.out.println(url);
}
}
