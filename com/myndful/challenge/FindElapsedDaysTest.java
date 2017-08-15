package com.myndful.challenge;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FindElapsedDaysTest 
{
	private FindElapsedDays findElapsedDays;
	private DateTimeFormatter formatter;

	@Before
	public void init() 
	{
		findElapsedDays = new FindElapsedDays();
		formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
	}

	/**
	 * This test case validates the given string's date format and parses to a Date object.
	 */
	@Test
	public void testValidateDate() {
		LocalDate expected = null;
		LocalDate actual = null;
		try {
			expected = LocalDate.parse("12/08/2000", formatter);
			actual = findElapsedDays.validateDate("12/08/2000");
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
		LocalDate actual = null;
		try {
			actual = findElapsedDays.validateDate("32/10/1986");
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
		LocalDate actual = null;
		try {
			actual = findElapsedDays.validateDate("29/02/1987");
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
		LocalDate expected = null;
		LocalDate actual = null;
		try {
			expected = LocalDate.parse("29/02/1948", formatter);
			actual = findElapsedDays.validateDate("29/02/1948");
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
		LocalDate actual = null;
		try {
			actual = findElapsedDays.validateDate("12/15/2000");
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
			long expected = 10;
			long actual = findElapsedDays.calculateElapsedFullDays(findElapsedDays.validateDate("22/10/1944"), findElapsedDays.validateDate("02/11/1944"));
			Assert.assertEquals(expected, actual);
			System.out.println("testCalculateElapsedFullDays # 22/10/1944 / 02/11/1944 : PASSED");
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
		long expected = 1;
		long actual = -1;
		try 
		{
			actual = findElapsedDays.calculateElapsedFullDays(findElapsedDays.validateDate("22/02/2045"), findElapsedDays.validateDate("02/11/2044"));
		} 
		catch (Exception e) 
		{
			System.err.println(e.getMessage());
		}
		Assert.assertNotEquals(expected, actual);
		System.out.println("testCalculateElapsedFullDays_StartDateAfter # 22/02/2045 / 02/11/2044 : PASSED");
	}
	
	/**
	 * This test case validates the elapsed number of days between 07/11/1972 and 08/11/1972 (excluding 07/11/1972 and 08/11/1972).
	 */
	@Test
	public void testCalculateElapsedFullDays_0() {
		try {
			long expected = 0;
			long actual = findElapsedDays.calculateElapsedFullDays(findElapsedDays.validateDate("07/11/1972"), findElapsedDays.validateDate("08/11/1972"));
			Assert.assertEquals(expected, actual);
			System.out.println("testCalculateElapsedFullDays_0 # 07/11/1972 / 08/11/1972 : PASSED");
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
			long expected = 1;
			long actual = findElapsedDays.calculateElapsedFullDays(findElapsedDays.validateDate("01/01/2000"), findElapsedDays.validateDate("03/01/2000"));
			Assert.assertEquals(expected, actual);
			System.out.println("testCalculateElapsedFullDays_1 # 01/01/2000 / 03/01/2000 : PASSED");
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
			long expected = 19;
			long actual = findElapsedDays.calculateElapsedFullDays(findElapsedDays.validateDate("02/06/1983"), findElapsedDays.validateDate("22/06/1983"));
			Assert.assertEquals(expected, actual);
			System.out.println("testCalculateElapsedFullDays_19 # 02/06/1983 / 22/06/1983 : PASSED");
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
			long expected = 173;
			long actual = findElapsedDays.calculateElapsedFullDays(findElapsedDays.validateDate("04/07/1984"), findElapsedDays.validateDate("25/12/1984"));
			Assert.assertEquals(expected, actual);
			System.out.println("testCalculateElapsedFullDays_173 # 04/07/1984 / 25/12/1984 : PASSED");
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
			long expected = 1979;
			long actual = findElapsedDays.calculateElapsedFullDays(findElapsedDays.validateDate("03/08/1983"), findElapsedDays.validateDate("03/01/1989"));
			Assert.assertEquals(expected, actual);
			System.out.println("testCalculateElapsedFullDays_1979 # 03/08/1983 / 03/01/1989 : PASSED");
		} 
		catch (Exception e) 
		{
			System.err.println(e.getMessage());
		}
	}

}
