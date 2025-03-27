package org.runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/org/featurefiles",
        glue = {"org.stepdef"},
        plugin = {
        	"pretty",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
               //"pretty",
               //"html:target/cucumber-html-report.html",
                "json:target/cucumber.json",
                "junit:target/cucumber.xml"
        },
        monochrome = true,
        dryRun = false
)
public class RunnerTest {
}
