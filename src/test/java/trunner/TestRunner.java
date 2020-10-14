package trunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
				features="./Feature",
				glue="steps",
				dryRun=false,
				monochrome=true,
				plugin= {"html:target/HTML/Report.html",
						"pretty:target/PRETTY/Report.txt",
						"json:target/JSON/Report.json",
						"junit:target/JUNIT/Report.xml"
				
						}
                )

public class TestRunner {

	
	

}
