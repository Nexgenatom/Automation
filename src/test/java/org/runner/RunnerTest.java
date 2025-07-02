package org.runner;
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;
//@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/org/featurefiles",
        glue = {"org.stepdef"},
        tags = "@default",
        plugin = {
        	//"pretty",
               "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
               //"pretty",
               "html:target/cucumber-html-report.html",
                "json:target/cucumber.json",
                "junit:target/cucumber.xml",
                "rerun:target/failed_scenarios.txt"

        },
        monochrome = true,
        dryRun = false
)
public class RunnerTest extends AbstractTestNGCucumberTests {

	/*
	 * @Override
	 * 
	 * @DataProvider(parallel = true) public Object[][] scenarios() { return
	 * super.scenarios(); }
	 */
}
