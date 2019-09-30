package com.mobiquityinc.facade;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.mobiquityinc.algorithm.KnapsackProblemSolver;
import com.mobiquityinc.algorithm.KnapsackProblemSolverImpl;
import com.mobiquityinc.exception.APIException;
import com.mobiquityinc.model.Item;
import com.mobiquityinc.model.ItemPackage;
import com.mobiquityinc.util.Constants;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PackageSolutionImpl implements PackageSolution {

	private final KnapsackProblemSolver knapsackSolver;

	public PackageSolutionImpl() {
		this(new KnapsackProblemSolverImpl());
	}

	@Override
	public String solveFromFile(List<ItemPackage> itemPackageList) throws APIException {
		if (CollectionUtils.isEmpty(itemPackageList))
			return StringUtils.EMPTY;
		
		return itemPackageList.stream().map(this::solutionHandler).collect(Collectors.joining("\n"));

	}

	private String solutionHandler(ItemPackage itemPackage) {

		List<Item> solution = knapsackSolver.solve(itemPackage);
		return displaySolution(solution);
	}

	public String displaySolution(List<Item> solution) {
		if (CollectionUtils.isEmpty(solution)) {
			return Constants.EMPTY_SOLUTION_PLACEHOLDER;
		}
		return solution.stream().sorted(Comparator.comparing(Item::getId)).mapToInt(Item::getId)
				.mapToObj(Integer::toString).collect(Collectors.joining(Constants.RESULT_DELIMETER));
	}

}