package com.mobiquityinc.reader;

import java.util.List;

import com.mobiquityinc.exception.APIException;
import com.mobiquityinc.model.ItemPackage;

public interface PackageInputReader {

	/**
	 * Reads a List of ItemPackage from an absolute file path.
	 * 
	 * @param filePath is an absolute file path.
	 * @return It is a list of Items packaged
	 * @throws APIException when the input file path is invalid or when the
	 *                file contains invalid data
	 */
	List<ItemPackage> readFile(String filePath) throws APIException;

}
