package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/feature", // Path to your feature files
        glue = {"hooks", "stepDefinition"},  // Package containing step definitions
        // tags = "@Smoke",
        dryRun = false, // Disable dry run
        plugin = {"pretty", "html:target/cucumber-reports.html"}, // Generate reports
        monochrome = true // Better console output
)
public class runnerclass {
}
