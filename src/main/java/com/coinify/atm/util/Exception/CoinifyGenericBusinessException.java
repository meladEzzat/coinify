/**
 * @author melad
 *
 * @date   7 Jul 2018
 * @action  File Created
 *
 */
package com.coinify.atm.util.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author melad
 * @class CoinifyGenericBusinessException.java
 * @tags
 */
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server Error")
public class CoinifyGenericBusinessException extends Exception {

	public CoinifyGenericBusinessException() {
		super();
	}

	public CoinifyGenericBusinessException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CoinifyGenericBusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	public CoinifyGenericBusinessException(String message) {
		super(message);
	}

	public CoinifyGenericBusinessException(Throwable cause) {
		super(cause);
	}
}
