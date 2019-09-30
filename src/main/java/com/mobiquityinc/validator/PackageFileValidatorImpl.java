package com.mobiquityinc.validator;

import java.nio.file.Paths;

import org.apache.commons.lang3.StringUtils;

import com.mobiquityinc.exception.APIException;
import com.mobiquityinc.util.Constants;
import com.mobiquityinc.util.DelimeterConstants;

/**
 * This component is responsible for all validations.
 * 
 * @author Mario Ponciano 
 *
 */
public class PackageFileValidatorImpl implements PackageFileValidator {

	@Override
	public boolean verifyFileExists(String filePath) throws APIException {
		if(StringUtils.isBlank(filePath))
			throw new APIException("File does not exists in provided path");
		
		boolean isFileExists = Paths.get(filePath).toFile().exists();
		if (!isFileExists)
			throw new APIException("File does not exists in provided path");

		return true;
	}
	
	@Override
	public void validate(int item, int weight, Double cost, int packageWeightLimit) throws APIException {
		this.validateMaxItemAmountConstraint(item);
		this.validateMaxItemWeightConstraint(weight);
		this.validateMaxCostConstraint(cost);
		this.validatePackageWeightLimit(packageWeightLimit);
	}

	@Override
	public boolean isValidInputLineFormat(String line) throws APIException {
		boolean lineMatches = line.matches(DelimeterConstants.VALID_INPUT_LINE_FORMAT.getDelimeter());
		if (!lineMatches)
			throw new APIException("The input line doesn't match with the valid format.");

		return true;
	}

	@Override
	public void validateMaxItemAmountConstraint(int itemAmount) throws APIException {
		if (itemAmount > Constants.MAX_ITEMS_AMOUNT) {
			throw new APIException(Constants.PACKAGE_ITEM_WEIGHT_LIMIT_EXCEDED_MESSAGE);
		}
	}

	@Override
	public void validateMaxCostConstraint(Double cost) throws APIException {
		if (cost > Constants.MAX_ITEM_COST) {
			throw new APIException(Constants.PACKAGE_ITEM_COST_EXCEDED_MESSAGE);
		}

	}

	@Override
	public void validatePackageWeightLimit(int pkgWeighLimit) throws APIException {
		if (pkgWeighLimit > Constants.MAX_PACKAGE_WEIGHT) {
			throw new APIException(Constants.PACKAGE_LIMIT_WEIGHT_EXCEDED_MESSAGE);
		}

	}
	
	@Override
	public void validateMaxItemWeightConstraint(int itemWeight) throws APIException {
		if (itemWeight > Constants.MAX_ITEM_WEIGHT) {
			throw new APIException(Constants.PACKAGE_LIMIT_WEIGHT_EXCEDED_MESSAGE);
		}

	}

}
