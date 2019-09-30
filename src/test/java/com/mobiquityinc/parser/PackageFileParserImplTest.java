package com.mobiquityinc.parser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mobiquityinc.exception.APIException;

public class PackageFileParserImplTest {

	private PackageFileParser packageFileParser;

	@BeforeEach
	void init() {
		this.packageFileParser = new PackageFileParserImpl();
	}

	@Test
	public void testParseSingleLine() throws APIException {
		final String line = "81 : (1,53.38,€45) (2,88.62,€98) (3,78.48,€3) (4,72.30,€76) (5,30.18,€9) (6,46.34,€48) ";
		packageFileParser.parseSingleLine(line);

	}

	@Test
	public void testParseInvalidLineFormat() throws APIException {
		Assertions.assertThrows(APIException.class, () -> {
			final String line = "81 - (1,53.38,R$45) ";
			packageFileParser.parseSingleLine(line);
		});
	}

	@Test
	public void testParseNullLine() throws APIException {
		packageFileParser.parseSingleLine(null);
	}

}
