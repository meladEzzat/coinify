/**
 * @author melad
 *
 * @date   7 Jul 2018
 * @action  File Created
 *
 */
package com.coinify.atm.request;

/**
 * @author melad
 * @class CoinifyAtmRequest.java
 * @tags
 */
public class CoinifyAtmRequest {
	private Integer amount;

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "CoinifyAtmRequest [amount=" + amount + "]";
	}
}
