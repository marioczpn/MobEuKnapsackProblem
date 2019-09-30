package com.mobiquityinc.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mobiquityinc.exception.APIException;

public class PackageFileValidatorImplTest {
	private PackageFileValidator validator;

	@BeforeEach
	void init() {
		this.validator = new PackageFileValidatorImpl();
	}

	@Test
	public void testFileExists() throws APIException {
		this.validator.verifyFileExists("inputSample.txt");
	}

	@Test
	public void testInvalidFileExists_thenReturnAPIException() throws APIException {
		Assertions.assertThrows(APIException.class, () -> {
			this.validator.verifyFileExists("wrong.txt");
		});
	}
	
	@Test
	public void testNoFile_thenReturnAPIException() throws APIException {
		Assertions.assertThrows(APIException.class, () -> {
			this.validator.verifyFileExists("");
		});
	}

	@Test
	public void testValidationsWithCorrectValues() throws APIException {
		this.validator.validate(1, 3, 20.20, 81);
	}

	@Test
	public void testValidInputLineFormat() throws APIException {
		this.validator.isValidInputLineFormat("8 : (1,15.3,€34) ");
	}

	@Test
	public void testInputLineFormat_thenReturnAPIException() throws APIException {
		Assertions.assertThrows(APIException.class, () -> {
			this.validator.isValidInputLineFormat("invalid-line|kkj");
		});
	}
	
	@Test
	public void testInvalidMaxCost_thenReturnAPIException() throws APIException {
		Assertions.assertThrows(APIException.class, () -> {
			this.validator.validateMaxCostConstraint(1000.00);
		});
	}
	
	@Test
	public void testInvalidMaxItemAmount_thenReturnAPIException() throws APIException {
		Assertions.assertThrows(APIException.class, () -> {
			this.validator.validateMaxItemAmountConstraint(25);
		});
	}
	
	@Test
	public void testInvalidMaxItemWeight_thenReturnAPIException() throws APIException {
		Assertions.assertThrows(APIException.class, () -> {
			this.validator.validateMaxItemWeightConstraint(300);
		});
	}
	
	@Test
	public void testInvalidPackageWeightLimit_thenReturnAPIException() throws APIException {
		Assertions.assertThrows(APIException.class, () -> {
			this.validator.validatePackageWeightLimit(300);
		});
	}



}
