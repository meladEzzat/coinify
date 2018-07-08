/**
 * @author melad
 *
 * @date   5 Jul 2018
 * @action  File Created
 *
 */
package com.coinify.atm.service.impl;

import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Component;

import com.coinify.atm.response.CoinifyAtmResponse;
import com.coinify.atm.service.IProcessor;
import com.coinify.atm.util.PayoutBoxUtil;

/**
 * @author melad
 * @class CoinifyProcessor.java
 * @tags
 */
@Component
public class CoinifyProcessor implements IProcessor {

	@Override
	public CoinifyAtmResponse withdarw(Integer amount) {

		CoinifyAtmResponse response = new CoinifyAtmResponse();

		if (amount == null || amount == 0) {
			response.setMessage("Please entr valid amount");
			return response;
		}

		if (!PayoutBoxUtil.checkEnoughMoney(amount)) {
			response.setMessage("Sorry, Not enough money");
			return response;
		}

		Map<Integer, Integer> notesAndCoinsResult = new TreeMap<>();

		for (Map.Entry<Integer, Integer> item : PayoutBoxUtil.getAvailablePayouts().entrySet()) {

			Integer unitFactor = amount / item.getKey();
			if (unitFactor == 0 || unitFactor > item.getValue())
				continue;

			notesAndCoinsResult.put(item.getKey(), amount / item.getKey());
			amount = amount % item.getKey();
		}

		if (notesAndCoinsResult.isEmpty() || amount > 0) {
			response.setMessage("Sorry, No matching notes");
			notesAndCoinsResult.clear();
		}

		response.setNotesAndCoinsResult(notesAndCoinsResult);

		PayoutBoxUtil.updateAvailablePayouts(notesAndCoinsResult);
		return response;
	}
}
