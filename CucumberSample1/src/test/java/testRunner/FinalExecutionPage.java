package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features=".//Featured//Logs.feature",
		glue="pages",
		monochrome=true,
		plugin= {"pretty","html:test-output"}
		)


public class FinalExecutionPage {

}
