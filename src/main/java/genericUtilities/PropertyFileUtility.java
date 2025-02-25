package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class consist of generic method to use property file
 * @author Sneha
 */
public class PropertyFileUtility {

	/**
	 * This method will read the data from property file and return the value to caller 
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readDataFromPropetyFile(String key) throws IOException
	{
		FileInputStream fil = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		Properties p = new Properties();
		
		p.load(fil);
		
		String value =p.getProperty(key);
		
		return value;
	}
}