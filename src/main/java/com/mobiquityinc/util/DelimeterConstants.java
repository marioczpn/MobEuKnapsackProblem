package com.mobiquityinc.util;

public enum DelimeterConstants {
   WEIGHT_CONTENT_DELIMETER(" : "),
   COMMA_SEPARATOR(","),
   CURRENCY_SYMBOL("€"),
   VALID_INPUT_LINE_FORMAT("^\\d+\\s*?:\\s*\\(\\s*\\d+\\s*,\\s*\\d*\\.{0,1}\\d+\\s*,\\s*€\\d*\\.{0,1}\\d+\\s*\\).*$"),
   EMPTY_SOLUTION_PLACEHOLDER("-");
	
	private String regex;

	DelimeterConstants(String regex) {
		this.regex = regex;
	}

	public String getDelimeter() {
		return regex;
	}

}
