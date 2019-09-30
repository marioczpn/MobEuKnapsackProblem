package com.mobiquityinc.reader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mobiquityinc.exception.APIException;

public class PackageInputReaderImplTest {

	private PackageInputReader reader;

	@BeforeEach
	void init() {
		this.reader = new PackageInputReaderImpl();
	}

	@Test
	public void testValidFilePath() throws APIException {
		this.reader.readFile("inputSample.txt");
	}

	@Test
	public void testInvalidFilePath() throws APIException {
		Assertions.assertThrows(APIException.class, () -> {
			this.reader.readFile("wrongFile.txt");
		});
	}

	@Test
	public void testNullFilePath() throws APIException {
		Assertions.assertThrows(APIException.class, () -> {
			this.reader.readFile(null);
		});
	}

}
