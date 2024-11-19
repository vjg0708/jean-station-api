package com.example.app_jeanstation.TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = ("C:\\Users\\david.doggala\\eclipse-workspace\\JeanStationProject\\app-jeanstation\\src\\test\\java\\com\\example\\app_jeanstation\\Features\\JeanStation.feature"),
		glue = {"StepDefinition"},
		plugin = {"pretty"},
		monochrome = true 
		)




public class JeanStation_TestRunner {

}
