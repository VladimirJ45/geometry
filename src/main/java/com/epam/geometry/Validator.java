package com.epam.geometry;

import java.util.regex.Pattern;

// TODO: make this name more specific (according to your task)
public class Validator {

	// Do validation using regexp
	// this method should not be long, just 1-2 lines
	// keep your line pattern as constant in this class
	public boolean validate(String line) {
		String pattern = "(-)?\\d+(\\.\\d+)\\s(-)?\\d+(\\.\\d+)\\s(-)?\\d+(\\.\\d+)\\s(-)?\\d+(\\.\\d+)\\s(-)?\\d+(\\.\\d+)\\s(-)?\\d+(\\.\\d+)";
		boolean result = Pattern.matches(pattern, line);
		return result;
	}
	
}
