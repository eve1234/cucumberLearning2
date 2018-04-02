package testCode;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		//all the features are in the Festures folder
		features = "Features",
		glue = "testCode"
		
		)
public class CucumberRunner {
	
	

}
