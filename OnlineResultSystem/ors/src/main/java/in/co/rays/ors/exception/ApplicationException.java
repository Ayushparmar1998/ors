package in.co.rays.ors.exception;

/**
 * ApplicationException is propogated from Service classes when an business
 * logic exception occurered.
 * @author AYUSH
 *
 */
public class ApplicationException extends Exception {
	
	/**
	 * @param msg
	 *      : Error message
	 */
	public ApplicationException(String msg) {
		super(msg);
		
		}

}
