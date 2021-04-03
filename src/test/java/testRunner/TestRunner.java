
package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
        glue = "stepDefinitions",
        tags = "@success"
        , plugin = {"pretty", "html:target/site/cucumber-pretty"})
public class TestRunner {

}
