package com.mobiquityinc.facade;

import java.util.List;

import com.mobiquityinc.exception.APIException;
import com.mobiquityinc.model.ItemPackage;

public interface PackageSolution {

	/**
	 * This method will process a given package and based on the knapsack algorithm
	 * it will determine which things to put into the package.
	 * 
	 * @param itemPackageList
	 * @return String
	 * @throws APIException
	 */
	String solveFromFile(List<ItemPackage> itemPackageList) throws APIException;
}
