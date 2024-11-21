package com.example.app_jeanstation.StepDefinition;

import io.cucumber.spring.CucumberContextConfiguration;
import io.restassured.RestAssured;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ActiveProfiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@ActiveProfiles("test")
@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CucumberSpringConfiguration {


}
