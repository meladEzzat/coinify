/**
 * @author melad
 *
 * @date   7 Jul 2018
 * @action  File Created
 *
 */
package com.coinify.atm.util.api.error;

import org.springframework.http.HttpStatus;

/**
 * @author melad
 * @class ApiError.java
 * @tags
 */
public class ApiError {
	private HttpStatus status;
	private String message;

	public ApiError(HttpStatus status, String message) {
		super();
		this.status = status;
		this.message = message;

	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ApiError [status=" + status + ", message=" + message + "]";
	}

}
