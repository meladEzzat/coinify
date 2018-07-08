/**
 * @author melad
 *
 * @date   5 Jul 2018
 * @action  File Created
 *
 */

package com.coinify.atm.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.coinify.atm.service.IProcessor;

import io.swagger.annotations.Api;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author melad
 * @class HomeController.java
 * @tags
 */
@Controller
@ApiIgnore
public class HomeController extends BaseController {

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		System.out.println("Home Page Requested, locale = " + locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "index";
	}

	@RequestMapping(value = "/withdraw", method = RequestMethod.GET)
	public String withdraw(Integer amount, ModelMap model) {

		model.addAttribute("amount", amount);
		model.addAttribute("notesAndCoinsResult", processor.withdarw(amount));
		return "ATM";

	}
}