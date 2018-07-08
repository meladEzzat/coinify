/**
 * @author melad
 *
 * @date   6 Jul 2018
 * @action  File Created
 *
 */
package com.coinify.atm.response;

import java.util.Map;

/**
 * @author melad
 * @class CoinifyAtmResponse.java
 * @tags
 */
public class CoinifyAtmResponse {

	private Map<Integer, Integer> notesAndCoinsResult;

	private String message;

	public Map<Integer, Integer> getNotesAndCoinsResult() {
		return notesAndCoinsResult;
	}

	public void setNotesAndCoinsResult(Map<Integer, Integer> notesAndCoinsResult) {
		this.notesAndCoinsResult = notesAndCoinsResult;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "CoinifyAtmResponse [notesAndCoinsResult=" + notesAndCoinsResult + ", message=" + message + "]";
	}

}
