package com.mobiquityinc.suite;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages({ 
	"com.mobiquityinc.algorithm",
	"com.mobiquityinc.facade", 
	"com.mobiquityinc.model",
	"com.mobiquityinc.packer", 
	"com.mobiquityinc.parser",
	"com.mobiquityinc.reader", 
	"com.mobiquityinc.util",
	"com.mobiquityinc.validator"
	})
public class TestSuite {

}
