/**
 * @author melad
 *
 * @date   7 Jul 2018
 * @action  File Created
 *
 */
package com.coinify.atm.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.coinify.atm.service.IProcessor;

/**
 * @author melad
 * @class BaseController.java
 * @tags
 */
public class BaseController {

	@Autowired
	public IProcessor processor;

}
