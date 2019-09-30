package com.mobiquityinc.packer;

import java.util.List;

import com.mobiquityinc.exception.APIException;
import com.mobiquityinc.facade.PackageSolution;
import com.mobiquityinc.facade.PackageSolutionImpl;
import com.mobiquityinc.model.ItemPackage;
import com.mobiquityinc.reader.PackageInputReader;
import com.mobiquityinc.reader.PackageInputReaderImpl;

/**
 * This class will test several packs and it will return the best Item's indexes
 * for each row of the file.
 * 
 * @author Mario Ponciano <marioczpn@gmail.com>
 *
 */
public class Packer {

	private static PackageInputReader reader = new PackageInputReaderImpl();
	private static PackageSolution resolver = new PackageSolutionImpl();

	private Packer() {
	}

	/**
	 * The method does return the knapsack solution as a String.
	 * 
	 * @param absolute path to a test file as a String
	 * @return the solution as a String
	 * @throws APIException
	 */
	public static String pack(String fileName) throws APIException {
		List<ItemPackage> itemPackageList = reader.readFile(fileName);
		return resolver.solveFromFile(itemPackageList);

	}

}
