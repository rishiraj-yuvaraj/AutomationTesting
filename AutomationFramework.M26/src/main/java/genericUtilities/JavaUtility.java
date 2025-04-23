package genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class consists of generic methods related to Java
 * @author ADMIN
 * 
 */

public class JavaUtility {

	/**
	 * This method will return the current system date in specific format
	 * @return
	 */
	public String getSystemDateInFormat() {
		Date d = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("dd-mm-yyyy_hh-mm-ss");
		String date = sf.format(d);
		return date;
	}
}
