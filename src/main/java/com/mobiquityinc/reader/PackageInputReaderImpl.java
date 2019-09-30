package com.mobiquityinc.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.mobiquityinc.exception.APIException;
import com.mobiquityinc.model.ItemPackage;
import com.mobiquityinc.parser.PackageFileParser;
import com.mobiquityinc.parser.PackageFileParserImpl;
import com.mobiquityinc.validator.PackageFileValidator;
import com.mobiquityinc.validator.PackageFileValidatorImpl;

import lombok.RequiredArgsConstructor;

/**
 * This component is responsible for reading a raw file.
 * 
 * @author Mario Ponciano
 *
 */
@RequiredArgsConstructor
public class PackageInputReaderImpl implements PackageInputReader {

	private final PackageFileValidator validator;
	private final PackageFileParser parser;

	public PackageInputReaderImpl() {
		this(new PackageFileValidatorImpl(), new PackageFileParserImpl());
	}

	@Override
	public List<ItemPackage> readFile(String filePath) throws APIException {
		if(!validator.verifyFileExists(filePath))
			return Collections.emptyList();
		
		try (Stream<String> linesStream = Files.lines(Paths.get(filePath))) {

			return linesStream.map(this::validateAndParseSingleLine).collect(Collectors.toList());

		} catch (IOException e) {
			throw new APIException(e.getMessage(), e);
		}
	}

	private ItemPackage validateAndParseSingleLine(String line) {
		ItemPackage itemsPackaged = new ItemPackage();
		try {
			itemsPackaged = parser.parseSingleLine(line);

		} catch (APIException e) {
			System.err.println( e.getMessage ( ) + "/n The stack trace is :") ;
		}

		return itemsPackaged;
	}


}
