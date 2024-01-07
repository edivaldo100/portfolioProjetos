package br.com.edivaldo.exception;

/**
 * Classe de exceções da app
 * 
 * @author Edivaldo
 * @version 1.0.0
 * @since Release 01 da aplicação
 */

public class RestException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4313377028983992430L;

	public RestException() {
		super();
	}

	public RestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public RestException(String message, Throwable cause) {
		super(message, cause);
	}

	public RestException(String message) {
		super(message);
	}

	public RestException(Throwable cause) {
		super(cause);
	}

}
