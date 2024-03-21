package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "D:\\API Automation FrameWork\\RestAssuredTestedFreamwork\\src\\test\\java\\features\\AddPlaceAPI.feature", 
plugin = "json:target/jsonReports/cucumber-report.json", 
glue = {"stepDefinations" },
tags = "@Regression" 
)

public class TestRunner {

}
