/**
 * @author melad
 *
 * @date   6 Jul 2018
 * @action  File Created
 *
 */
package com.coinify.atm.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author melad
 * @class PayoutBoxUtil.java
 * @tags
 */
@Component()
@Scope(value = "singleton")
public class PayoutBoxUtil {

	private static Map<Integer, Integer> notesAndCoinsUnits = new HashMap<Integer, Integer>();

	@PostConstruct
	private void init() {
		notesAndCoinsUnits.put(1000, 100);
		notesAndCoinsUnits.put(500, 100);
		notesAndCoinsUnits.put(200, 100);
		notesAndCoinsUnits.put(100, 100);
		notesAndCoinsUnits.put(50, 100);
		notesAndCoinsUnits.put(20, 100);
		notesAndCoinsUnits.put(10, 100);
		notesAndCoinsUnits.put(5, 100);
		notesAndCoinsUnits.put(2, 100);
		notesAndCoinsUnits.put(1, 100);
	}

	public static Map<Integer, Integer> getAvailablePayouts() {
		Map<Integer, Integer> availablePayouts = new HashMap<>();

		for (Map.Entry<Integer, Integer> entry : notesAndCoinsUnits.entrySet()) {
			if (entry.getValue() > 0) {
				availablePayouts.put(entry.getKey(), entry.getValue());
			}
		}

		return sortByKey(availablePayouts);
	}

	public static void updateAvailablePayouts(Map<Integer, Integer> notesAndCoinsUpdates) {
		Integer key;
		Integer newValue;
		for (Map.Entry<Integer, Integer> entry : notesAndCoinsUpdates.entrySet()) {

			key = entry.getKey();
			newValue = notesAndCoinsUnits.get(key) - entry.getValue();

			notesAndCoinsUnits.put(key, newValue);
		}
	}

	public static void resetPayoutBox(Integer payoutBoxUnit) {
		notesAndCoinsUnits.put(payoutBoxUnit, 100);
	}

	public static boolean checkEnoughMoney(Integer amount) {

		Long totalFund = 0l;
		for (Map.Entry<Integer, Integer> entry : notesAndCoinsUnits.entrySet()) {

			totalFund = totalFund + (entry.getKey() * entry.getValue());
		}

		return totalFund >= amount;

	}

	private static Map<Integer, Integer> sortByKey(Map<Integer, Integer> unsortMap) {

		List<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(unsortMap.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				return (o2.getKey()).compareTo(o1.getKey());
			}
		});

		Map<Integer, Integer> sortedMap = new LinkedHashMap<Integer, Integer>();
		for (Map.Entry<Integer, Integer> entry : list) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}

		return sortedMap;
	}

	public static Map<Integer, Integer> getNotesAndCoinsUnits() {
		return notesAndCoinsUnits;
	}

	public static void setNotesAndCoinsUnits(Map<Integer, Integer> notesAndCoinsUnits) {
		PayoutBoxUtil.notesAndCoinsUnits = notesAndCoinsUnits;
	}

}
