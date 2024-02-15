package framework;

import framework.utils.SoftAsserts;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.util.Objects;

import static framework.utils.PropertiesReader.getConfigProperty;

public class Hooks {
    
    @Before
    public void beforeScenario() {
        Setup.driver = BrowserFactory.getInstance(Objects.requireNonNull(getConfigProperty("browser.name")));
        SoftAsserts.cleanSoftAsserts();
    }
    
    @After
    public void afterScenario() {
        if (Setup.driver != null) {
            Setup.driver.quit();
        }
        SoftAsserts.checkSoftAsserts();
    }
}