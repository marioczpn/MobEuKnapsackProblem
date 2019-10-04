package com.mobiquityinc.algorithm;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.mobiquityinc.model.Item;
import com.mobiquityinc.model.ItemPackage;

public class KnapsackProblemSolverImplTest {

	private static KnapsackProblemSolver knapsackSolver;
	private static ItemPackage itemPackage;

	@BeforeAll
	public static void init() {
		knapsackSolver = new KnapsackProblemSolverImpl();
		itemPackage = buildItemPackage(new Item(5, 30.0, 9.0), new Item(6, 46.0, 48.0), new Item(1, 53.0, 45.0),
				new Item(4, 72.0, 76.0), new Item(3, 78.0, 3.0));
	}

	@Test
	public void testSolveWithValidParameters() {
		Item item = new Item();
		List<Item> expectedValue = new ArrayList<>();
		item.setId(4);
		item.setWeight(72.0);
		item.setCost(76.0);
		expectedValue.add(item);

		itemPackage.setMaxPackageWeight(81);
		List<Item> actualSolution = knapsackSolver.solve(itemPackage);
 
		assertEquals(expectedValue, actualSolution);
		assertNotNull(actualSolution);
	}

	@Test
	public void testSolveWithInvalidParameters() {
		List<Item> actualSolution = knapsackSolver.solve(null);

		assertTrue(actualSolution.isEmpty());
	}

	@Test
	public void whenMaxPackageWeightIsSet_withoutItemPackage() {
		ItemPackage ipkg = new ItemPackage();
		ipkg.setMaxPackageWeight(0);
		List<Item> actualSolution = knapsackSolver.solve(ipkg);
		
		assertTrue(actualSolution.isEmpty());
	}
	
	@Test
	public void whenItemPackageWasBuilt_withoutMaxPackageWeight() {
		List<Item> actualSolution = knapsackSolver.solve(itemPackage);
		
		assertTrue(!actualSolution.isEmpty());
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
