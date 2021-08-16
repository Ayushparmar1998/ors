package in.co.rays.ors.util;

import java.util.Date;

/**
 * To validate input output data
 * @author AYUSH
 *
 */
/**
 * @author AYUSH
 *
 */
/**
 * @author AYUSH
 *
 */
/**
 * @author AYUSH
 *
 */
public class DataValidator {
	
	/**
	 * Check if value is Null
	 * @param val
	 * @return boolean
	 */
	
	public static boolean isNull(String val) {

		if (val == null || val.trim().length() == 0) {
			return true;
		} else {
			return false;
		}

	}
	/**
	 * check if value is Not Null
	 * @param val
	 */
	public static boolean isNotNull(String val) {
		return !isNull(val);
	}

	/**
	 * check if an value is an Integer
	 * @param val
	 * @return boolean
	 */
	public static boolean isInteger(String val) {
		// String s = val.trim(); // Modified

		if (isNotNull(val)) {
			try {
				int i = Integer.parseInt(val);
				return true;
			} catch (Exception e) {
				return false;
			}
		} else {
			return false;
		}
	}
  
	/**
	 * check if an value is an Long
	 * @param val
	 * @return boolean
	 */
	public static boolean isLong(String val) {

		// String s = val.trim(); // Modified

		if (isNotNull(val)) {
			try {
				long l = Long.parseLong(val);
				return true;
			} catch (Exception e) {
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	  * Check if value is valid EmailId
	  * @param val
	  * @return boolean
	  */  
	public static boolean isEmail(String val) {
		String emailreg = "^[_a-zA-Z0-9+]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		// modified
		if (isNotNull(emailreg)) {
			return val.matches(emailreg);

		}

		else {
			return false;
		}

	}
	/**
	  * check if value is date
	  * @param val
	  * @return boolean
	  */
	public static boolean isDate(String val) {

		Date d = null;

		if (isNotNull(val)) {

			d = DataUtility.getDate(val);
			long d1 = d.getTime();
			System.out.println("date is" + d);
			System.out.println("date is" + d1);

		}
		return d != null;
	}

	
	public static boolean isName(String name) { // my method created

		//String namereg = "^[a-zA-Z]+$";

		//String namere = "^[^-\\s][\\p{L} .']+$";
		// String sname = name.trim();

		// String namer = "^/S+/w/S";
		String namer = "^[a-zA-Z_-]+$";
		if (isNotNull(name) && name.matches(namer)) {

			return true;
		} else {
			return false;
		}
	}

	
	public static boolean isName1(String name) { // my method created

		String namere = "^[^-\\s][\\p{L} .']+$";

		if (isNotNull(name) && name.matches(namere)) {

			return true;
		} else {
			return false;
		}
	}

	/**
	 * Checks if value of Password is in between 8 and 12 characters
	 * 
	 * @param pass
	 * @return true or false
	 */
	public static boolean isPassword(String pass) { // my method created

		System.out.println("validate pass");
		String passreg = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20})";
		// String passreg="^[0-9a-zA-Z]{5}$";
		// String spass = pass.trim();
		// int checkIndex = spass.indexOf(" ");
		// checkIndex==-1
		if (isNotNull(pass) && pass.matches(passreg)) {
			System.out.println("true");
			return true;
		}

		else {
			return false;
		}
	}

	
	public static boolean isAddress(String pass) { // my method created

		System.out.println("validate pass");
	//	String passreg = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{8,20})";

//		String passreg = "^[0-9a-zA-Z/s,-]+$";
		String passreg = "^[0-9a-zA-Z\\s,-]+$";
		// String passreg="^[0-9a-zA-Z]{5}$";
		// String spass = pass.trim();
		// int checkIndex = spass.indexOf(" ");
		// checkIndex==-1
		if (isNotNull(pass) && pass.matches(passreg)) {
			System.out.println("true");
			return true;
		}

		else {
			return false;
		}
	}
	
	public static boolean isRollNo(String roll) { // my method created
		// System.out.println("rollno");
		// String rollreg =
		// "((?=.*\\d).{1,4}(?=.*[A-Z]).{1,2}(?=.*\\d).{1,6})$";
		// String rollreg="^[a-zA-z\\s]+$";
		String rollreg = "^[0-9]{2}[A-Za-z]{2}[0-9]{2,6}$";
		// String sroll = roll.trim();
		
//		neer = [a-zA-Z]{2}[0-9]{4}
		if (DataValidator.isNotNull(roll)) {

			boolean check = roll.matches(rollreg);
			System.out.println(check);
			return check;
		}

		else {

			return false;
		}
	}

	/**
	 * Checks if value of Mobile No is 10
	 * 
	 * @param mobile
	 * @return boolean
	 */
	public static boolean isMobileNo(String mobile) {

		String mobilereg = "^[6-9][0-9]{9}$";

		if (isNotNull(mobile) && mobile.matches(mobilereg)) {

			return true;
		} else {
			return false;
		}

	}

	/**
	 * Checks if value is valid Phone No.
	 * 
	 * @param phone
	 * @return boolean
	 */
	public static boolean isPhoneNo(String phone) {

		String mobilereg = "^[0-9][0-9]{10}$";

		if (isNotNull(phone) && phone.matches(mobilereg)) {

			return true;
		} else {
			return false;
		}

	}

	
	public static boolean isValidAge(String val) {

		Date today = new Date();

		System.out.println(today);

		Date enterDate = DataUtility.getDate(val);

		System.out.println(enterDate);

		int age = today.getYear() - enterDate.getYear();
		System.out.println("age=" + age);

		if (age > 18 && isNotNull(val)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	  * Test Above Methods
	  * @param args
	  */  
	public static void main(String[] args) {
		DataValidator d = new DataValidator();
		// System.out.println(d.isNull(" ds "));
		// System.out.println(d.isNotNull(" "));
		// System.out.println(d.isInteger(" as d"));
		// System.out.println(d.isEmail("_ankur@gmailcom"));
		// System.out.println(d.isPassword("DIVkitwe@12"));
		// System.out.println(d.isName("Acdchj"));
		// System.out.println(d.isRollNo("01IT12"));
		//System.out.println(d.isValidAge("18-06-2000"));
		System.out.println(d.isAddress("23 c sunder Nagar"));

		// System.out.println(d.isMobileNo("98933382275"));
	}

}
