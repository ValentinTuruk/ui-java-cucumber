package framework;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;

@CucumberOptions(
        features = "src/test/java/onliner/features",
        glue = {"onliner.stepdefenitions", "framework"}
)
public class Setup extends AbstractTestNGCucumberTests {
    public static WebDriver driver;
}