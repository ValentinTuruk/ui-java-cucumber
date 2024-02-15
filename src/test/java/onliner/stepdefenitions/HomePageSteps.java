package onliner.stepdefenitions;

import framework.Browser;
import io.cucumber.java.en.Given;
import onliner.pageobjects.pages.HomePage;

public class HomePageSteps {
    
    @Given("Open {string} page")
    public void openPage(String pageName) {
        Browser.navigateTo(String.format("%s.page", pageName.toLowerCase()));
    }
    
    @Given("Navigate to {string} application section")
    public void navigateToApplicatoinSection(String section) {
        var homePage = new HomePage();
        homePage.getTopNavigationBar().navigateToApplicatoinSection(section);
    }
}
