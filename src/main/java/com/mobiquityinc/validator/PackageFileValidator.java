package com.mobiquityinc.validator;

import com.mobiquityinc.exception.APIException;

public interface PackageFileValidator {

	/**
	 * Tests whether the file pathname exists.
	 * 
	 * @param filePath is the name of the file.
	 * @return true if and only if the file pathname exists; and throws exception
	 *         otherwise
	 * @throws APIException when the input file path is invalid or when the file
	 *                      contains invalid data
	 */
	boolean verifyFileExists(String filePath) throws APIException;

	/**
	 * Test all item's value whether the package is valid based on constraints.
	 * 
	 * @param item               is an integer
	 * @param weight             is an integer
	 * @param cost               is a double
	 * @param packageWeightLimit is a interger
	 * @throws APIException when the input file path is invalid or when the file
	 *                      contains invalid data
	 */
	public void validate(int item, int weight, Double cost, int packageWeightLimit) throws APIException;

	/**
	 * Tests if the input line has the valid format specified in the regular
	 * expression.
	 * 
	 * @param line
	 * @return true for valid; false otherwise
	 */
	boolean isValidInputLineFormat(String line) throws APIException;

	/**
	 * Validate if the package has a valid weight to be created accordingly with the
	 * constraint defined.
	 * 
	 * @param maxWeight
	 * @throws APIException
	 */
	void validateMaxItemAmountConstraint(int maxWeight) throws APIException;

	/**
	 * Validate if the package don't exceed the dvalid package based on constraint.
	 * 
	 * @param cost
	 * @throws APIException
	 */
	void validateMaxCostConstraint(Double cost) throws APIException;

	/**
	 * Validate if the package has a package weight limit expected.
	 * 
	 * @param pkgWeighLimit
	 * @throws APIException
	 */
	void validatePackageWeightLimit(int pkgWeighLimit) throws APIException;

	/**
	 * Validate if the package has a item weight limit expected.
	 * 
	 * @param itemWeight
	 * @throws APIException
	 */
	void validateMaxItemWeightConstraint(int itemWeight) throws APIException;

}
