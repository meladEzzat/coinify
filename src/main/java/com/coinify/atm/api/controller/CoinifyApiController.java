/**
 * @author melad
 *
 * @date   7 Jul 2018
 * @action  File Created
 *
 */
package com.coinify.atm.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coinify.atm.controller.BaseController;
import com.coinify.atm.request.CoinifyAtmRequest;
import com.coinify.atm.response.CoinifyAtmResponse;
import com.coinify.atm.util.Exception.CoinifyGenericBusinessException;

/**
 * @author melad
 * @class CoinifyApiController.java
 * @tags
 */
@Controller
@RequestMapping(value = "/api/v1/")
public class CoinifyApiController extends BaseController {

	@RequestMapping(value = "/withdarw", method = RequestMethod.POST)
	public @ResponseBody CoinifyAtmResponse withdraw(@RequestBody CoinifyAtmRequest coinifyAtmRequest) throws CoinifyGenericBusinessException {
		try {
			return processor.withdarw(coinifyAtmRequest.getAmount());
		} catch (Exception e) {
			throw new CoinifyGenericBusinessException(e.getMessage());
		}
	}
}
