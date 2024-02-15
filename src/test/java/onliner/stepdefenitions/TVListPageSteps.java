package onliner.stepdefenitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import onliner.pageobjects.pages.TVListPage;

public class TVListPageSteps {
    @When("Set vendor filter: {string}")
    public void setVendorFilter(String vendor) {
        var tvListPage = new TVListPage();
        tvListPage.getTvFilters().setVendor(vendor);
    }
    
    @When("Set max price filter: {string}")
    public void setMaxPriceFilter(String maxPrice) {
        var tvListPage = new TVListPage();
        tvListPage.getTvFilters().setMaxPrice(maxPrice);
    }
    
    @When("Set resolution filter: {string}")
    public void setResolutionFilter(String resolution) {
        var tvListPage = new TVListPage();
        tvListPage.getTvFilters().setResolution(resolution);
    }
    
    @When("Set min diagonal filter: {string}")
    public void setMinDiagonalFilter(String minDiagonal) {
        var tvListPage = new TVListPage();
        tvListPage.getTvFilters().setMinDiagonal(minDiagonal);
    }
    
    @When("Set max diagonal filter: {string}")
    public void setMaxDiagonalFilter(String maxDiagonal) {
        var tvListPage = new TVListPage();
        tvListPage.getTvFilters().setMaxDiagonal(maxDiagonal);
    }
    
    @Then("Verify all filtered results match vendor: {string}")
    public void verifyVendor(String vendor) {
        var tvListPage = new TVListPage();
        tvListPage.getTvList().verifyTitleText(vendor);
    }
    @Then("Verify all filter results match max price: {string}")
    public void verifyMaxPrice(String maxPrice) {
        var tvListPage = new TVListPage();
        double price = Double.valueOf(maxPrice);
        tvListPage.getTvList().verifyMaxPrice(price);
    }
    
    @Then("Verify all filter results match resolution: {string}")
    public void verifyResolution (String resolution) {
        var tvListPage = new TVListPage();
        tvListPage.getTvList().verifyResolution(resolution);
    }
    
    @Then("Verify all filter results match min diagonal: {string}")
    public void verifyMinDiagonal(String minDiagonal) {
        var tvListPage = new TVListPage();
        int diagonal = Integer.valueOf(minDiagonal);
        tvListPage.getTvList().verifyMinDiagonalSize(diagonal);
    }
    
    @Then("Verify all filter results match max diagonal: {string}")
    public void verifyMaxDiagonal (String maxDiagonal) {
        var tvListPage = new TVListPage();
        int diagonal = Integer.valueOf(maxDiagonal);
        tvListPage.getTvList().verifyMaxDiagonalSize(diagonal);
    }
}
