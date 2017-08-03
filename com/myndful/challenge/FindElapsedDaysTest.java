package com.myndful.challenge;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

public class FindElapsedDaysTest 
{
	private SimpleDateFormat dateFormat;

	@Before
	public void init() 
	{
		dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);
	}

	/**
	 * This test case validates the given string's date format and parses to a Date object.
	 */
	@Test
	public void testValidateDate() {
		Date expected = null;
		Date actual = null;
		try {
			expected = dateFormat.parse("12/08/2000");
			actual = FindElapsedDays.validateDate("12/08/2000");
			Assert.assertEquals(expected, actual);
			System.out.println("testValidateDate # 12/08/2000 : PASSED");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	/**
	 * This test case validate the given string's date format and attempts to parse to a Date object but fails as the day is invalid.
	 */
	@Test
	public void testInValidDay() {
		Date actual = null;
		try {
			actual = FindElapsedDays.validateDate("32/10/1986");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		Assert.assertNull(actual);
		System.out.println("testInValidDay # 32/10/1986 : PASSED");
	}

	/**
	 * This test case validate the given string's date format and attempts to parse to a Date object but fails as the day is invalid.
	 */
	@Test
	public void testInValidDayInLeapYear() {
		Date actual = null;
		try {
			actual = FindElapsedDays.validateDate("29/02/1987");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		Assert.assertNull(actual);
		System.out.println("testInValidDayInLeapYear # 29/02/1987 : PASSED");
	}
	
	/**
	 * This test case validate the given string's date format and parses to a Date object.
	 */
	@Test
	public void testValidDayInLeapYear() {
		Date expected = null;
		Date actual = null;
		try {
			expected = dateFormat.parse("29/02/1948");
			actual = FindElapsedDays.validateDate("29/02/1948");
			Assert.assertEquals(expected, actual);
			System.out.println("testValidDayInLeapYear # 29/02/1948 : PASSED");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * This test case validate the given string's date format and attempts to parse to a Date object but fails as the month is invalid.
	 */
	@Test
	public void testInValidMonth() {
		Date actual = null;
		try {
			actual = FindElapsedDays.validateDate("12/15/2000");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		Assert.assertNull(actual);
		System.out.println("testInValidMonth # 12/15/2000 : PASSED");
	}

	/**
	 * This test case validates the elapsed number of days between 22/10/1944 and 02/11/1944 (excluding 22/10/1944 and 02/11/1944).
	 */
	@Test
	public void testCalculateElapsedFullDays() 
	{
		try 
		{
			int expected = 10;
			int actual = FindElapsedDays.calculateElapsedFullDays("22/10/1944", "02/11/1944");
			Assert.assertEquals(expected, actual);
			System.out.println("testCalculateElapsedFullDays # 22/10/1944 - 02/11/1944 : PASSED");
		} 
		catch (Exception e) 
		{
			System.err.println(e.getMessage());
		}
	}
	
	/**
	 * This test case attempts to calculate the elapsed number of days between 22/10/1945 and 02/11/1944.
	 * which will fail to calculate as start date (22/02/2045) is after end date (02/11/2044)
	 */
	@Test
	public void testCalculateElapsedFullDays_StartDateAfter() 
	{
		int expected = 1;
		int actual = -1;
		try 
		{
			actual = FindElapsedDays.calculateElapsedFullDays("22/02/2045", "02/11/2044");
		} 
		catch (Exception e) 
		{
			System.err.println(e.getMessage());
		}
		Assert.assertNotEquals(expected, actual);
		System.out.println("testCalculateElapsedFullDays_StartDateAfter # 22/02/2045 - 02/11/2044 : PASSED");
	}
	
	/**
	 * This test case validates the elapsed number of days between 07/11/1972 and 08/11/1972 (excluding 07/11/1972 and 08/11/1972).
	 */
	@Test
	public void testCalculateElapsedFullDays_0() {
		try {
			int expected = 0;
			int actual = FindElapsedDays.calculateElapsedFullDays("07/11/1972", "08/11/1972");
			Assert.assertEquals(expected, actual);
			System.out.println("testCalculateElapsedFullDays_0 # 07/11/1972 - 08/11/1972 : PASSED");
		} catch (Exception e) {
			System.err.println(e.getMessage());

		}
	}

	/**
	 * This test case validates the elapsed number of days between 01/01/2000 and 03/01/2000 (excluding 01/01/2000 and 03/01/2000).
	 */
	@Test
	public void testCalculateElapsedFullDays_1() {
		try {
			int expected = 1;
			int actual = FindElapsedDays.calculateElapsedFullDays("01/01/2000", "03/01/2000");
			Assert.assertEquals(expected, actual);
			System.out.println("testCalculateElapsedFullDays_1 # 01/01/2000 - 03/01/2000 : PASSED");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * This test case validates the elapsed number of days between 02/06/1983 and 22/06/1983 (excluding 02/06/1983 and 22/06/1983).
	 */
	@Test
	public void testCalculateElapsedFullDays_19() {
		try {
			int expected = 19;
			int actual = FindElapsedDays.calculateElapsedFullDays("02/06/1983", "22/06/1983");
			Assert.assertEquals(expected, actual);
			System.out.println("testCalculateElapsedFullDays_19 # 02/06/1983 - 22/06/1983 : PASSED");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * This test case validates the elapsed number of days between 04/07/1984 and 25/12/1984 (excluding 04/07/1984 and 25/12/1984).
	 */
	@Test
	public void testCalculateElapsedFullDays_173() {
		try {
			int expected = 173;
			int actual = FindElapsedDays.calculateElapsedFullDays("04/07/1984", "25/12/1984");
			Assert.assertEquals(expected, actual);
			System.out.println("testCalculateElapsedFullDays_173 # 04/07/1984 - 25/12/1984 : PASSED");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * This test case validates the elapsed number of days between 03/08/1983 and 03/01/1989 (excluding 03/08/1983 and 03/01/1989).
	 */
	@Test
	public void testCalculateElapsedFullDays_1979() 
	{
		try 
		{
			int expected = 1979;
			int actual = FindElapsedDays.calculateElapsedFullDays("03/08/1983", "03/01/1989");
			Assert.assertEquals(expected, actual);
			System.out.println("testCalculateElapsedFullDays_1979 # 03/08/1983 - 03/01/1989 : PASSED");
		} 
		catch (Exception e) 
		{
			System.err.println(e.getMessage());
		}
	}

}
