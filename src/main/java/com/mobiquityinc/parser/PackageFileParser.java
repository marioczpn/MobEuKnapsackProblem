package com.mobiquityinc.parser;

import com.mobiquityinc.exception.APIException;
import com.mobiquityinc.model.ItemPackage;

public interface PackageFileParser {

	/**
	 * Method to parse single line and it will return the items packaged in a way
	 * that it is easy to process.
	 * 
	 * @param line
	 * @return a list of items packaged.
	 * @throws APIException
	 */
	ItemPackage parseSingleLine(String line) throws APIException;

}
