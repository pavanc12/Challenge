package com.myndful.challenge;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.time.temporal.ChronoUnit;

/**
 * The FindElapsedDays class calculates implements an application that
 * calculates the full elapsed days between any two given dates excluding the
 * given dates. This class accepts the input from command-Line/Terminal.
 * 
 * @author pavan
 */
public class FindElapsedDays {

	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");

	/**
	 * @param args A String Array with 2 Dates in DD/MM/YYYY format.
	 */
	public static void main(String[] args) {
		if (args.length != 2) {
			System.err.println("Please enter Valid arguments");
			System.exit(0);
		}
		try {
			FindElapsedDays findElapsedDays = new FindElapsedDays();
			long daysElapsed = findElapsedDays.calculateElapsedFullDays((findElapsedDays.validateDate(args[0])),
					findElapsedDays.validateDate(args[1]));
			System.out.println("Full days elapsed between " + args[0] + " and " + args[1] + " : " + daysElapsed);
		} catch (Exception e) {
			System.err.println(e.getMessage() + " Please try again");
		}
	}

	/**
	 * This method calculates the elapsed number of days between given start date
	 * and end date (excluding start date and end date)
	 * 
	 * @param startDate A LocalDate which holds input start date
	 * @param endDate A LocalDate which holds input end date
	 * @return long
	 * @throws Exception
	 * 
	 */
	long calculateElapsedFullDays(LocalDate startDate, LocalDate endDate) throws Exception {
		if (startDate.isAfter(endDate))
			throw new Exception("Start date should be before End date. Please try again.");
		// Adding 1 day to start date as the between method includes start date but excludes end date
		return ChronoUnit.DAYS.between(startDate.plusDays(1), endDate);
	}

	/**
	 * This method validates the format of the input string, parses the string and
	 * converts to LocalDate object
	 * 
	 * @param inputDate A String which has to be validated and converted to a LocalDate object
	 * @return LocalDate
	 */
	LocalDate validateDate(String inputDate) {
		return LocalDate.parse(inputDate, formatter.withResolverStyle(ResolverStyle.STRICT));
	}
}
