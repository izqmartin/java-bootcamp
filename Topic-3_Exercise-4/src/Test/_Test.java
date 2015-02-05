package Test;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Classes.RomanNumbers;

public class _Test {

	@Before
	public void setUp() throws Exception {
		System.out.println("Starting");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Ending");
	}
	

	@Test
	public void IntToRomanTest() {
		RomanNumbers toRoman = new RomanNumbers();
		int number= 1212;
		String string = toRoman.IntToRoman(number);
		System.out.println(string);
		Assert.assertEquals("MCCXII", string);
	}
	@Test
	public void RomanToIntTest() {
		RomanNumbers toInt = new RomanNumbers();
		int integ = toInt.RomanToInt("MCCXII");
		System.out.println(integ);
		Assert.assertEquals(1212, integ);
	}

}
