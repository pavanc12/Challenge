package com.myndful.challenge;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 * The FindElapsedDays class calculates implements an application that
 * calculates the full elapsed days between any two given dates excluding the given dates.
 * This class accepts the input from command-Line/Terminal and GUI.
 * 
 * @author pavan
 */
public class FindElapsedDays {
	/**
	 * @param args A String Array with 2 Dates in DD/MM/YYYY format.
	 */
	public static void main(String[] args) {
		String expStartDate = "", expEndDate = "";
		if (args.length == 2) {
			expStartDate = args[0];
			expEndDate = args[1];
		} 
		else if (args.length == 0) {
			expStartDate = JOptionPane.showInputDialog(null, "Please Enter Experiment Start date (DD/MM/YYYY)", "INPUT",JOptionPane.PLAIN_MESSAGE);
			expEndDate = JOptionPane.showInputDialog(null, "Please Enter Experiment End date (DD/MM/YYYY)", "INPUT",JOptionPane.PLAIN_MESSAGE);
		}  
		else {
			System.err.println("Please enter Valid arguments");
			System.exit(0);
		}
		if(expStartDate == null || expEndDate == null || expStartDate.length() !=10 || expEndDate.length() !=10){
			System.err.println("Invalid input date(s). Please input Valid Dates in DD/MM/YYYY format");
			if(args.length == 0) JOptionPane.showMessageDialog(null, "Invalid input date(s).\nPlease input Valid Dates","ERROR", JOptionPane.ERROR_MESSAGE);
			System.exit(0);	
		}	
		try{
			int daysElapsed = calculateElapsedFullDays(expStartDate, expEndDate);
			System.out.println("Full days elapsed between " + expStartDate + " and " + expEndDate + " : " + daysElapsed);
			if (args.length == 0)
				JOptionPane.showMessageDialog(null,"Full days elapsed between " + expStartDate + " and " + expEndDate + " : " + daysElapsed,"RESULT", JOptionPane.PLAIN_MESSAGE);
		} 
		catch (Exception e) {
			System.err.println(e.getMessage()+" Please try again");
			if (args.length == 0)
				JOptionPane.showMessageDialog(null, e.getMessage()+"\nPlease try again","ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * This method calculates the elapsed number of days between given start date and end date
	 * (excluding start date and end date)
	 * 
	 * @param startDate A String which holds input start date
	 * @param endDate A String which holds input end date
	 * @return int
	 * @throws ParseException,Exception
	 * 
	 */
	protected static int calculateElapsedFullDays(String startDate, String endDate) throws ParseException,Exception {	
		int elapsedDays = 0;
		Calendar expStartDate = Calendar.getInstance();
		Calendar expEndDate = Calendar.getInstance();
		expStartDate.setTime(validateDate(startDate));
		expEndDate.setTime(validateDate(endDate));
		if(expStartDate.after(expEndDate)) throw new Exception("Start date should be before End date. Please try again.");
		expStartDate.add(Calendar.DAY_OF_MONTH, 1);
		while (expStartDate.before(expEndDate)) {
			elapsedDays++;
			expStartDate.add(Calendar.DAY_OF_MONTH, 1);
		}
		return elapsedDays;
	}

	/**
	 * This method validates the format of the input string, parses the string and converts to date object
	 * 
	 * @param inputDate A String which has to be validated and converted to a date
	 * @return Date
	 * @throws ParseException
	 */
	protected static Date validateDate(String inputDate) throws ParseException{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);
		return dateFormat.parse(inputDate);
	}
}
