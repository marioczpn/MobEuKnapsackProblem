package com.mobiquityinc.algorithm;

import java.util.List;

import com.mobiquityinc.model.Item;
import com.mobiquityinc.model.ItemPackage;

public interface KnapsackProblemSolver {
	

	/**
     * Solve the knapsack problem with branch and bound algorithm.
     * 
	 * @param itemPackage
	 * @return a list of item after solution.
	 */
	List<Item> solve(ItemPackage itemPackage);
}
