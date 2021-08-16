package in.co.rays.ors.exception;

/**
 * DuplicateRecordException thrown when a duplicate record occurred
 * @author AYUSH
 *
 */
public class DuplicateRecordException extends Exception {
	
	/**
	 * @param msg
	 * error msg
	 */
	public DuplicateRecordException(String msg){
		super(msg);
	}
}
