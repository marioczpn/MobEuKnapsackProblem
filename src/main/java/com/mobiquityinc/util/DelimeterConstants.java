package com.mobiquityinc.util;

public enum DelimeterConstants {
   WEIGHT_CONTENT_DELIMETER(" : "),
   ITEM_BLOCK_START_TOKEN("("),
   ITEM_BLOCK_END_TOKEN(")"),
   ITEM_PROPERTY_SEPARATOR(","),
   DECIML_SEPARATOR("."),
   CURRENCY_SYMBOL("€"),
   INPUT_LINE_REGEX("^\\d+\\s*?:\\s*\\(\\s*\\d+\\s*,\\s*\\d*\\.{0,1}\\d+\\s*,\\s*€\\d*\\.{0,1}\\d+\\s*\\).*$"),
   VALID_INPUT_LINE_FORMAT("^\\d+\\s*?:\\s*\\(\\s*\\d+\\s*,\\s*\\d*\\.{0,1}\\d+\\s*,\\s*€\\d*\\.{0,1}\\d+\\s*\\).*$");
	
	private String regex;

	DelimeterConstants(String regex) {
		this.regex = regex;
	}

	public String getDelimeter() {
		return regex;
	}

}
