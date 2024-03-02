package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="D:\\RestAssuredAPIAutomationFramWorks\\YogeshNale\\src\\test\\java\\features",
				plugin="json:target/jsonReports/cucumber-report.json",
		glue= {"stepDefinations"} )
//tags= "@DeletePlace"
public class TestRunner {
//All things We need to write in above class name
	//this comment is added for to add then code in master branch 
}
