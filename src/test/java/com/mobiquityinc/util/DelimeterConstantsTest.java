package com.mobiquityinc.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DelimeterConstantsTest {

	@Test
	public void testDelimeter() {
		assertEquals(" : ", DelimeterConstants.WEIGHT_CONTENT_DELIMETER.getDelimeter());
		assertEquals("€", DelimeterConstants.CURRENCY_SYMBOL.getDelimeter());
		assertEquals("^\\d+\\s*?:\\s*\\(\\s*\\d+\\s*,\\s*\\d*\\.{0,1}\\d+\\s*,\\s*€\\d*\\.{0,1}\\d+\\s*\\).*$", DelimeterConstants.VALID_INPUT_LINE_FORMAT.getDelimeter());
	}
}
