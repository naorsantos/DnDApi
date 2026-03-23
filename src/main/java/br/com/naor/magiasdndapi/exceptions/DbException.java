/**
 * 
 */
package br.com.naor.magiasdndapi.exceptions;

/**
 * 
 */
public class DbException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final String sqlState;
	private final int errorCode;

	public DbException(String message, Throwable cause, String sqlState, int errorCode) {
		super(message, cause);
		this.sqlState = sqlState;
		this.errorCode = errorCode;
	}

	public String getSqlState() {
		return sqlState;
	}

	public int getErrorCode() {
		return errorCode;
	}

	@Override
	public String toString() {
		return "DbException [sqlState=" + sqlState + ", errorCode=" + errorCode + "]";
	}

}
