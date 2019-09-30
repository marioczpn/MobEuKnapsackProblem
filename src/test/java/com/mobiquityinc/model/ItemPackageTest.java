package com.mobiquityinc.model;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ItemPackageTest {

	@Test
	public void whenItemPackageHasValidParameters() {
		ItemPackage itemPkg = new ItemPackage();
		itemPkg.setMaxPackageWeight(81);

		List<Item> itemsPackedList = new ArrayList<>();
		itemsPackedList.add(new Item(5, 30, 9.0));
		itemPkg.setPackedItems(itemsPackedList);

		assertNotNull(itemPkg);
	}
	
	@Test
	public void whenAddParameterWithBuilder() {
		ItemPackage.builder().maxPackageWeight(50).packedItems(new ArrayList<>());
	}
	
	@Test
	public void whenItemPackageIsNull() {
		ItemPackage itemPkg = new ItemPackage();
		itemPkg.setMaxPackageWeight(0);
		itemPkg.setPackedItems(null);

		assertNotNull(itemPkg);
	}

}
