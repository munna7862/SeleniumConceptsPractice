package runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "D:\\Eclipse Oxygen\\Eclipse_Workspace\\ConceptsPractice\\src\\main\\java\\featurefiles",
		glue={"stepDefinitions"},
		format={"pretty","html:test-outout","json:json_output/cucumber.json","junit:junit_xml/cucumber.xml"},
		dryRun = false,
		monochrome = true,
		strict = true,
		tags= {"@Google"}
		)

public class RunnerClass {
	
}
