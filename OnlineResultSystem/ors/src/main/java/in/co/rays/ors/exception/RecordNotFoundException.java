package in.co.rays.ors.exception;

/**
 *  RecordNotFoundException thrown when a record not found occurred
 * @author AYUSH
 *
 */
public class RecordNotFoundException extends Exception {

	/**
	 * @param msg
	 *      : Error message
	 */
	public RecordNotFoundException(String msg) {
		super(msg);
	}
}
