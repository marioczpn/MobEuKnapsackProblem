package com.mobiquityinc.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * The class represents an item's packaged along with the capacity.
 * 
 * @author Mario Ponciano 
 *
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class ItemPackage {

	private int maxPackageWeight;

	private List<Item> packedItems;

	public Double getTotalItemsWeight() {
		return this.packedItems.stream().mapToDouble(Item::getWeight).sum();
	}

}
