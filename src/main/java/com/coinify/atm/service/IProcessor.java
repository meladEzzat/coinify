/**
 * @author melad
 *
 * @date   5 Jul 2018
 * @action  File Created
 *
 */
package com.coinify.atm.service;

import com.coinify.atm.response.CoinifyAtmResponse;

/**
 * @author melad
 * @class IProcessor.java
 * @tags
 */
public interface IProcessor {

	/**
	 * @param amount
	 * @return CoinifyAtmResponse
	 * 
	 */
	public CoinifyAtmResponse withdarw(Integer amount);
	
}
