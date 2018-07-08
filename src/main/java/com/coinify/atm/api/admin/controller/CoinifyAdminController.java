/**
 * @author melad
 *
 * @date   7 Jul 2018
 * @action  File Created
 *
 */
package com.coinify.atm.api.admin.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coinify.atm.controller.BaseController;
import com.coinify.atm.util.PayoutBoxUtil;
import com.coinify.atm.util.Exception.CoinifyGenericBusinessException;

/**
 * @author melad
 * @class CoinifyAdminController.java
 * @tags
 */
@Controller
@RequestMapping(value = "/api/admin/")
public class CoinifyAdminController extends BaseController {

	@RequestMapping(value = "/payout/box", method = RequestMethod.GET)
	public @ResponseBody Map<Integer, Integer> pauout() throws CoinifyGenericBusinessException {
		try {
			return PayoutBoxUtil.getNotesAndCoinsUnits();
		} catch (Exception e) {
			throw new CoinifyGenericBusinessException(e.getMessage());
		}
	}

	@RequestMapping(value = "/payout/box", method = RequestMethod.POST)
	public @ResponseBody Map<Integer, Integer> resetPauout(@RequestBody List<Integer> notesAndCoinsResetRequest)
			throws CoinifyGenericBusinessException {
		try {
			for (Integer item : notesAndCoinsResetRequest) {
				PayoutBoxUtil.resetPayoutBox(item);
			}
			return pauout();
		} catch (Exception e) {
			throw new CoinifyGenericBusinessException(e.getMessage());
		}
	}
}
