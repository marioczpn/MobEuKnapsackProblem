package com.mobiquityinc.packer;

import static org.junit.Assert.assertTrue;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.mobiquityinc.exception.APIException;

public class PackerTest {

	@Test
	public void testValidInputFile() throws APIException {
		String actual = Packer.pack("inputSample.txt");

		System.out.println(actual);
		assertTrue(StringUtils.isNotBlank(actual));
	}

	@Test
	public void testEmptyFilePath() throws APIException {
		Assertions.assertThrows(APIException.class, () -> {
			Packer.pack("");
		});
	}

	@Test
	public void testIncorrectFileData() throws APIException {
		Assertions.assertThrows(APIException.class, () -> {
			Packer.pack("doesNotExist.txt");
		});
	}
}
