package com.mobiquityinc.algorithm;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import com.mobiquityinc.model.Item;
import com.mobiquityinc.model.ItemPackage;

/**
 * This class is responsible to provide an interface to resolve the knapsack
 * problem based on BranchAndBound algorithm.
 * 
 * @author Mario Ponciano <marioczpn@gmail.com>
 *
 */
public class KnapsackProblemSolverImpl implements KnapsackProblemSolver {

	@Override
	public List<Item> solve(final ItemPackage itemPackage) {
		if (itemPackage == null || CollectionUtils.isEmpty(itemPackage.getPackedItems()))
			return Collections.emptyList();

		int itemSize = itemPackage.getPackedItems().size();
		int maxWeight = itemPackage.getMaxPackageWeight();
		double[][] possibleSolutions = new double[itemSize + 1][maxWeight + 1];

		for (int i = 0; i <= maxWeight; i++) {
			possibleSolutions[0][i] = 0;
		}

		for (int row = 1; row <= itemSize; row++) {

			Item item = itemPackage.getPackedItems().get(row - 1); // current Item

			for (int columnWeight = 1; columnWeight <= maxWeight; columnWeight++) {

				/*
				 * If the item does not fits within the actual weight take the previous solution
				 * for the current weight.
				 */
				if (item.getWeight() > columnWeight) {
					possibleSolutions[row][columnWeight] = possibleSolutions[row - 1][columnWeight];
				} else {
					/* Cost obtained when adding this item cost + previous cost without this item */
					double tookItemCost = item.getCost() + possibleSolutions[row - 1][columnWeight - item.getWeight()];
					
					/*
					 * If the total cost after adding this item is better than the previous value
					 * for this weight, it will became the better cost For the current weight
					 */
					possibleSolutions[row][columnWeight] = Math.max(tookItemCost, possibleSolutions[row - 1][columnWeight]);
				}

			}
		}

		return determineSolution(itemPackage, possibleSolutions);
	}

	/**
	 * 
	 * Determines the best solution among the previously calculated possibilities
	 * 
	 * @param itemPackage       the package being processed
	 * @param possibleSolutions a matrix with possible combinations of packages
	 * 
	 * @return a list of items with the best cost/weight for the package.
	 */
	private List<Item> determineSolution(ItemPackage itemPackage, double[][] possibleSolutions) {

		int itemSize = itemPackage.getPackedItems().size();
		int capacity = itemPackage.getMaxPackageWeight();

		List<Item> selectedItems = new LinkedList<>();

		/* The last row/column stores the maximum cost for this package */
		for (int row = itemSize; row > 0; row--) {

			/*
			 * If the total cost obtained in the last row/column of the matrix is not
			 * different than the previous row, it means that this item wasn't taken, so
			 * skip the item. If it's different it means this item is part of the solution
			 */
			if (possibleSolutions[row][capacity] != possibleSolutions[row - 1][capacity]) {
				Item item = itemPackage.getPackedItems().get(row - 1);
				selectedItems.add(item);
				capacity -= item.getWeight(); //update the total capacity
			}
		}

		return selectedItems;
	}
}
