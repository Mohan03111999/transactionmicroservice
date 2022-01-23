package com.trainingapps.forex.transactionms.util;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


import org.springframework.stereotype.Component;

@Component
public class DateConverter {

	private static final String PATTERN = "yyyy-MM-dd";
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(PATTERN);
	
	/**
	 * Converting LocalDate to String  
	 * @param date
	 * @return String
	 */
	public String toText(LocalDate date) {
		return FORMATTER.format(date);

	}

	/**
	 * Converting String to LocalDate  
	 * @param text
	 * @return LocalDate
	 */
	public LocalDate toDate(String text) {
		return LocalDate.parse(text, FORMATTER);
	}

	
}

