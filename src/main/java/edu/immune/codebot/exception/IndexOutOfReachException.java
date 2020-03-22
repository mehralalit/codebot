package edu.immune.codebot.exception;

/**
 * IndexOutOfReachException is thrown when a request to process a non existent position in the data structure is received.
 * @author Lalit Mehra
 *
 */
public class IndexOutOfReachException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8176526345003451312L;

	public IndexOutOfReachException() {
		super("Requested index out of reach");
	}
	
	public IndexOutOfReachException(String message) {
		super(message);
	}
	
}
