package com.mobiquityinc.facade;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;

import com.mobiquityinc.algorithm.KnapsackProblemSolverImpl;
import com.mobiquityinc.exception.APIException;
import com.mobiquityinc.model.Item;
import com.mobiquityinc.model.ItemPackage;

public class PackageSolutionTest {

	private static PackageSolution resolver;
	private static List<ItemPackage> itemPackageList;

	@BeforeAll
	public static void init() {
		resolver = new PackageSolutionImpl();
		itemPackageList = buildItemPackageList();
	}

	@Test
	public void whenValidParameter_thenReturnsTrue() throws APIException {
		String solveFromFile = resolver.solveFromFile(itemPackageList);

		assertNotNull(solveFromFile);

		//Mockito.verify(knapsackSolver, VerificationModeFactory.times(0)).solve(Mockito.any());

	}

	@Test
	public void whenNullParameter_thenReturnsEmptyString() throws APIException {
		KnapsackProblemSolverImpl knapsackSolverMock = Mockito.mock(KnapsackProblemSolverImpl.class);
		Mockito.when(knapsackSolverMock.solve(buildItemPackage(new Item()))).thenReturn(Collections.emptyList());
		
		String solution = resolver.solveFromFile(null);

		assertTrue(solution.isEmpty());
		
		Mockito.verify(knapsackSolverMock, VerificationModeFactory.times(0)).solve(Mockito.any());

	}

	@Test
	public void whenItemPackageList_whithoutItems() throws APIException {
		KnapsackProblemSolverImpl knapsackSolverMock = Mockito.mock(KnapsackProblemSolverImpl.class);
		Mockito.when(knapsackSolverMock.solve(buildItemPackage(new Item()))).thenReturn(Collections.emptyList());

		String solution = resolver.solveFromFile(itemPackageList);

		assertTrue(!solution.isEmpty());

	}

	private static List<ItemPackage> buildItemPackageList() {
		List<ItemPackage> itemPackageList = new ArrayList<>();

		itemPackageList.add(buildItemPackage(new Item(5, 30, 9.0), new Item(6, 46, 48.0), new Item(1, 53, 45.0),
				new Item(4, 72, 76.0), new Item(3, 78, 3.0)));

		itemPackageList.add(buildItemPackage(new Item(1, 15, 34.0)));

		return itemPackageList;

	}

	private static ItemPackage buildItemPackage(Item... itemList) {
		ItemPackage itemPackage = new ItemPackage();
		List<Item> itemsPackedList = new ArrayList<>();
		for (Item item : itemList) {
			itemsPackedList.add(item);
		}
		itemPackage.setPackedItems(itemsPackedList);

		return itemPackage;

	}
}
