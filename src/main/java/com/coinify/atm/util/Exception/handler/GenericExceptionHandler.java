/**
 * @author melad
 *
 * @date   7 Jul 2018
 * @action  File Created
 *
 */
package com.coinify.atm.util.Exception.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.coinify.atm.util.Exception.CoinifyGenericBusinessException;
import com.coinify.atm.util.api.error.ApiError;

/**
 * @author melad
 * @class GenericExceptionHandler.java
 * @tags
 */
@ControllerAdvice
@ResponseStatus(code=HttpStatus.INTERNAL_SERVER_ERROR)
public class GenericExceptionHandler {

	@ExceptionHandler(CoinifyGenericBusinessException.class)
	protected ResponseEntity<Object> handleException(Exception ex) {
		
		ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage());

		return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
	}
}
