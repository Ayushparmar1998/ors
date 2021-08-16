package in.co.rays.ors.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * data Utility class to format data
 * @author AYUSH
 *
 */
public class DataUtility {
	
	/**
	 * Application time data format
	 */
	public static final String APP_DATE_FORMAT = "dd-MM-yyyy";
	
	public static final String APP_TIME_FORMAT = "MM/dd/yyyy HH:mm:ss";
	
	/**
	 * Application time data format
	 */
	public static final SimpleDateFormat formatter = new SimpleDateFormat(APP_DATE_FORMAT );
	
	public static final SimpleDateFormat timeFormatter = new SimpleDateFormat(APP_TIME_FORMAT);

	

	/**
	 * 
	 * @param val
	 */
	
	public static String getString(String val) {
		if (DataValidator.isNotNull(val)) {
			return val.trim();
		} else {
			return val;
		}

	}

	/**
	 * Converts and Object to String
	 * 
	 * @param val
	 * @return String
	 */
    public static String getStringData(Object val) {
        if (val != null) {
            return val.toString();
        } else {
            return "";
        }
    }

    /**
	 * 
	 * Converts String InTo Integer
	 * 
	 * @param val
	 * @return int
	 */
	public static int getInt(String val) {

		//String trimNum = val.trim(); // Modified

		if (DataValidator.isInteger(val)) {

			int i = Integer.parseInt(val);
			return i;
		}

		else {
			return 0;
		}
	}

	/**
	 * 
	 * Converts String InTo Long
	 * 
	 * @param val
	 */
	public static long getLong(String val) {
	
		if (DataValidator.isLong(val)) {
			System.out.println("value in data utitlity getlong"+val);
			return Long.parseLong(val);
		} 
		
		
		else {
			return 0;
		}
	}

	/**
	 * Convert String in to Date
	 * 
	 * @param val
	 * @return d
	 */
	public static Date getDate(String val) {
		Date d = null;
		try {
			d = formatter.parse(val);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}

	/**
	 * convert string to date
	 * @param d
	 * @return String
	 */
	public static String getDateString(Date d) {
		try {
			return formatter.format(d);
		} catch (Exception e) {
          return "";
		}
	
	}


	 /**
	 * convert timeStamp to string
	 * @param val
	 * @return timeStamp
	 */
	public static Timestamp getTimeStamp(String val) {
		Timestamp timeStamp = null;
		try {
			timeStamp = new Timestamp(timeFormatter.parse(val).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return timeStamp;
	}

	 /** 
	 * convert timeStamp in to long
	 * @param l
	 * @return timeStamp
	 */
	public static Timestamp getTimestamp(long l) {

		Timestamp timeStamp = null;
		try {
			timeStamp = new Timestamp(l);
		} catch (Exception e) {
			return null;
		}
		return timeStamp;
	}

	 /**
	 * convert timeStamp in to string
	 * @return timeStamp
	 */
	public static Timestamp getCurrentTimestamp() {
		Timestamp timeStamp = null;
		try {

			timeStamp = new Timestamp(new Date().getTime());

		} catch (Exception e){ }

		return timeStamp;

	}

	 /**
	 * convert timeStamp to long
	 * @param tm
	 * @return long
	 */
	
	public static long getTimestamp(Timestamp tm) {
		try {
			return tm.getTime();
		} catch (Exception e) {
			return 0;
		}
	 }


	public static void main(String[] args) {

		// System.out.println(getInt(" 1@sd23 "));
		// System.out.println("This is GetTimeStamp Current =
		// "+getCurrentTimestamp());
		// String s = "Hewl";
		// Date d = new Date();
		// System.out.println(new Timestamp(new Date().getTime()));

		// System.out.println("Today's date "+getDateString(new Date()));
		// getCurrentTimestamp();
		// System.out.println( getCurrentTimestamp());
		// Timestamp st = new Timestamp(1552150570128L);
		// System.out.println(getTimestamp(new Date().getTime()));
		// Date date = new Date();
		// System.out.println(date.getTime());

		// Calendar cal = Calendar.getInstance();
		// System.out.println(getDateString(d));

		// String s = " 1234 ";
		// String tr = s.trim();
		// int rs = tr.indexOf(' ');
		// System.out.println(rs);
		// if(tr !=null && rs == -1){
		// System.out.println(tr);
		// }else {
		// System.out.println("00");
		// }
		//
		// }
}

}
