/**
 * @author melad
 *
 * @date   6 Jul 2018
 * @action  File Created
 *
 */
package coinifyAtm;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.collection.IsMapContaining;
import org.junit.Before;
import org.junit.Test;

import com.coinify.atm.response.CoinifyAtmResponse;
import com.coinify.atm.service.impl.CoinifyProcessor;
import com.coinify.atm.util.PayoutBoxUtil;

/**
 * @author melad
 * @class CoinifyAtmTest.java
 * @tags
 */
public class CoinifyAtmTest {

	Map<Integer, Integer> notesAndCoinsUnits = new HashMap<Integer, Integer>();
	
	@Before
	public void beforeEachTest() {
		notesAndCoinsUnits.put(1000, 1);
		notesAndCoinsUnits.put(500, 1);
		notesAndCoinsUnits.put(200, 1);
		notesAndCoinsUnits.put(100, 1);
		notesAndCoinsUnits.put(50, 1);
		notesAndCoinsUnits.put(20, 1);
		notesAndCoinsUnits.put(10, 1);
		notesAndCoinsUnits.put(5, 1);
		notesAndCoinsUnits.put(2, 1);
		notesAndCoinsUnits.put(1, 1);

		PayoutBoxUtil.setNotesAndCoinsUnits(notesAndCoinsUnits);
	}

	@Test
	public void notEnoughMoneyTest() {

		CoinifyProcessor tester = new CoinifyProcessor();
		CoinifyAtmResponse response = tester.withdarw(2000);

		// 1. Test null message
		assertNotNull("Messgae is null",response.getMessage());
		
		//4. Test messge contents
		assertEquals("Wrong message" , response.getMessage(),"Sorry, Not enough money");
	}

	@Test
	public void notTheRightNotesOrCoinsTest() {

		notesAndCoinsUnits = new HashMap<Integer, Integer>();
		notesAndCoinsUnits.put(100, 1);
		PayoutBoxUtil.setNotesAndCoinsUnits(notesAndCoinsUnits);
		
		
		CoinifyProcessor tester = new CoinifyProcessor();
		CoinifyAtmResponse response = tester.withdarw(70);

		// 1. Test null message
		assertNotNull("Messgae is null",response.getMessage());
		
		//4. Test messge contents
		assertEquals("Wrong message" , response.getMessage(),"Sorry, No matching notes");
	}
	
	
	@Test
	public void simpleWithdrawOperatopnsTest() {

		CoinifyProcessor tester = new CoinifyProcessor();
		CoinifyAtmResponse response = tester.withdarw(1);

		// 1. Test size
		assertThat(response.getNotesAndCoinsResult().size(), is(1));

		// 2. Test map key
		assertThat(response.getNotesAndCoinsResult(), IsMapContaining.hasKey(1));

		// 3. Test map value
		assertThat(response.getNotesAndCoinsResult(), IsMapContaining.hasValue(1));	
		
		//4. Test payout box after withdraw operation
		assertEquals("Wrong notes or coins left in the box" , Integer.valueOf(notesAndCoinsUnits.get(1)),Integer.valueOf(0));
	}

	@Test
	public void complexWithdrawOperatopnsTest() {

		CoinifyProcessor tester = new CoinifyProcessor();
		CoinifyAtmResponse response = tester.withdarw(578);

		// 1. Test size
		assertThat(response.getNotesAndCoinsResult().size(), is(6));

		// 2. Test map key
		assertThat(response.getNotesAndCoinsResult(), IsMapContaining.hasKey(500));
		assertThat(response.getNotesAndCoinsResult(), IsMapContaining.hasKey(50));
		assertThat(response.getNotesAndCoinsResult(), IsMapContaining.hasKey(20));
		assertThat(response.getNotesAndCoinsResult(), IsMapContaining.hasKey(5));
		assertThat(response.getNotesAndCoinsResult(), IsMapContaining.hasKey(2));
		assertThat(response.getNotesAndCoinsResult(), IsMapContaining.hasKey(1));
		

		// 3. Test map value
		assertThat(response.getNotesAndCoinsResult(), IsMapContaining.hasValue(1));	
		
		//4. Test payout box after withdraw operation
		assertEquals("Wrong notes or coins left in the box" , Integer.valueOf(notesAndCoinsUnits.get(500)),Integer.valueOf(0));
		assertEquals("Wrong notes or coins left in the box" , Integer.valueOf(notesAndCoinsUnits.get(50)),Integer.valueOf(0));
		assertEquals("Wrong notes or coins left in the box" , Integer.valueOf(notesAndCoinsUnits.get(20)),Integer.valueOf(0));
		assertEquals("Wrong notes or coins left in the box" , Integer.valueOf(notesAndCoinsUnits.get(5)),Integer.valueOf(0));
		assertEquals("Wrong notes or coins left in the box" , Integer.valueOf(notesAndCoinsUnits.get(2)),Integer.valueOf(0));
		assertEquals("Wrong notes or coins left in the box" , Integer.valueOf(notesAndCoinsUnits.get(1)),Integer.valueOf(0));

	}
	
}
