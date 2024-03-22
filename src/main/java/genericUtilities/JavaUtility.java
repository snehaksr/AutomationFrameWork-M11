package genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This Utility consist of java specific methods
 * @author Sneha
 */
public class JavaUtility {
/**
 * This method return current data in format
 * @return
 */
	
	public String getDate()
	{
		Date d = new Date();
		SimpleDateFormat f = new SimpleDateFormat("dd-MM-yy hh-mm-ss");
		String date = f.format(d);
		return date;
		
	}
}
