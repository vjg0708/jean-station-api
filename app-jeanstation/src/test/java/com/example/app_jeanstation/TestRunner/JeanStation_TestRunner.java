package com.example.app_jeanstation.TestRunner;

import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = ("C:\\Users\\david.doggala\\IdeaProjects\\jean-station-api\\app-jeanstation\\src\\test\\java\\com\\example\\app_jeanstation\\Features\\JeanStation.feature"),
		glue = {"com.example.app_jeanstation.StepDefinition"},
		plugin = {"pretty"},
		monochrome = true 
		)

public class JeanStation_TestRunner {

}
