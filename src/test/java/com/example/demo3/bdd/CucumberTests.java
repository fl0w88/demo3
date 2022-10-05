package com.example.demo3.bdd;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(//
        publish = true,
        features = "src/test/resources/cucumber/", //
        plugin = {"pretty",
                // uncomment the line below to also generate a test with all results in one JSON
                // "json:all_results.json"
        }
)
public class CucumberTests {
}
