package starter;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty", "json:target/cucumber.json"},
        features = "src/test/resources/features",
        glue= "com.manolopajaro.features.steps"
)
public class TestSuiteRunner {
}

