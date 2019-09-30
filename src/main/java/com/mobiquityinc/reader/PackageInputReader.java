package com.mobiquityinc.reader;

import java.util.List;

import com.mobiquityinc.exception.APIException;
import com.mobiquityinc.model.ItemPackage;

public interface PackageInputReader {

	/**
	 * Reads a {@link List} of {@link ItemPackage} from an absolute file path.
	 * 
	 * @param filePath the input file absolute path
	 * @return a {@link List} of {@link ItemPackage}
	 * 
	 * @throws {@link APIException} when the input file path is invalid or when the
	 *                file contains invalid data
	 */
	List<ItemPackage> readFile(String filePath) throws APIException;

}
