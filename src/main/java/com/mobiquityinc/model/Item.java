package com.mobiquityinc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * The class represents an entity object with (id, weight and cost) for holding
 * items.
 * 
 * @author Mario Ponciano 
 *
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class Item {
	private int id;
	private int weight;
	private Double cost;

}
