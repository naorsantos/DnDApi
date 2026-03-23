/**
 * 
 */
package br.com.naor.magiasdndapi.exceptions;

/**
 * 
 */
public class MagiaNotFoundException extends RuntimeException {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param message
	 */
	public MagiaNotFoundException(String message) {
		super(message);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public MagiaNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
