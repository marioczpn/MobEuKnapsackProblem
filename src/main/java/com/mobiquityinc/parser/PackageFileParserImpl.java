package com.mobiquityinc.parser;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.mobiquityinc.exception.APIException;
import com.mobiquityinc.model.Item;
import com.mobiquityinc.model.ItemPackage;
import com.mobiquityinc.util.DelimeterConstants;
import com.mobiquityinc.validator.PackageFileValidator;
import com.mobiquityinc.validator.PackageFileValidatorImpl;

/**
 * This class is responsible to parse from file to a structure that represents
 * the item that will be packaged.
 * 
 * @author MARIOCEZARPonciano
 *
 */
public class PackageFileParserImpl implements PackageFileParser {

	private static final int PACKAGE_CAPACITY = 0;
	private static final int INDEX = 1;
	private static final int WEIGHT = 2;
	private static final int COST = 3;
	private static Pattern pattern = Pattern.compile("\\((\\d+),(\\d+\\.?\\d*?),(\\d+)\\)");

	private PackageFileValidator validator;

	public PackageFileParserImpl() {
		validator = new PackageFileValidatorImpl();
	}

	@Override
	public ItemPackage parseSingleLine(String line) throws APIException {
		if (StringUtils.isBlank(line))
			return null;

		validator.isValidInputLineFormat(line);

		final String[] parameters = line.replaceAll(DelimeterConstants.CURRENCY_SYMBOL.getDelimeter(), "")
				.split(DelimeterConstants.WEIGHT_CONTENT_DELIMETER.getDelimeter());

		int maxPackageWeight = Integer.parseInt(parameters[PACKAGE_CAPACITY]);
		List<Item> items = parseGroups(parameters, maxPackageWeight);

		return ItemPackage.builder().maxPackageWeight(maxPackageWeight).packedItems(items).build();
	}

	/**
	 * Method is going through the parameters and separating each item (id, weight
	 * and cost) accordingly for a list of items.
	 * 
	 * @param parameters 
	 * @param maxPackageWeight
	 * @return List<Item>
	 * @throws APIException
	 */
	private List<Item> parseGroups(final String[] parameters, int maxPackageWeight) throws APIException {

		List<Item> items = new LinkedList<>();
		Matcher itemMatcher = pattern.matcher(parameters[1]);

		while (itemMatcher.find()) {
			int index = Integer.parseInt(itemMatcher.group(INDEX));
			Double weight = Double.valueOf(itemMatcher.group(WEIGHT));
			Double cost = Double.valueOf(itemMatcher.group(COST));

			validator.validate(index, weight.intValue(), cost, maxPackageWeight);

			if (weight <= maxPackageWeight) {
				items.add(Item.builder().id(index).weight(weight.intValue()).cost(cost).build());
			}

			itemMatcher.end();
		}

		return items.stream().sorted(Comparator.comparingDouble(Item::getWeight).thenComparing(Item::getCost))
				.collect(Collectors.toList());
	}

}
