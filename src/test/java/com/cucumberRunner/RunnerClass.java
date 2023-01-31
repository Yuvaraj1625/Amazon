package com.cucumberRunner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.mavenproject.Amazon1.Base_Class;
import com.properties.Configuration_Helper;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\kaaviyan\\eclipse-workspace\\Amazon_Project\\src\\test\\java\\com\\cucumberFeature\\Amazon.feature",
glue = "com.cucumberStepdefinnition.StepDefinition",tags = "@smoke",stepNotifications = true ,monochrome = true,plugin = "pretty")
public class RunnerClass {
	
	public static WebDriver driver;
	
	@BeforeClass
	public static void browserLaunch() throws Exception {

		String browser = Configuration_Helper.getInstanceCR().getbrowser();
		 driver = Base_Class.browserLaunch(browser); //chrome
	}
	@AfterClass
	public static void browserClose() {

		Base_Class.close();
//		driver.close();
	}

}
