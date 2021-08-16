package in.co.rays.ors.exception;

/**
 * DatabaseException is prpogated by DAO classes when an unhandled Database
 * exception occurred
 * @author AYUSH
 *
 */
public class DataBaseException extends Exception {
	
	/**
	 * @param msg
	 * error message
	 */
	public DataBaseException(String msg) {
		super(msg);
	}
}
