package com.mobiquityinc.model;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

public class ItemTest {
	
	@Test
	public void whenItemHasValidParameters() {
		Item item = new Item(1, 15, 34.0);
		assertNotNull(item);
	}
	
	@Test
	public void whenAddParameterWithBuilder() {
		Item.builder().id(1).weight(5).cost(5.0D).build();
	}
	
	@Test
	public void whenItemHasNullValue() {
		Item item = new Item(1, 1500, null);
		assertNotNull(item);
	}
	
	@Test
	public void whenItemWithInvalidWeight() {
		Item item = new Item(1, 1500, 34.0);
		assertNotNull(item);
	}
	
	@Test
	public void whenItemHasConstructorEmpty() {
		Item item = new Item();
		assertNotNull(item);
	}
}
