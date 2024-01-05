package br.com.edivaldo.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Classe de exceções da app
 * 
 * @author Edivaldo
 * @version 1.0.0
 * @since Release 01 da aplicação
 */
@Data
@AllArgsConstructor
public class AppException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4313377028983992430L;

	private String msg;

}
