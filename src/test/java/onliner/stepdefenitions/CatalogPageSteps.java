package onliner.stepdefenitions;

import io.cucumber.java.en.Given;
import onliner.pageobjects.pages.CatalogPage;

public class CatalogPageSteps {
    
    @Given("Navigate to {string} catalog located in {string} subdepartment of {string} department")
    public void navigateToTechnicTypeCatalog (String technicType, String subdepartment, String department){
        var catalogPage = new CatalogPage();
        catalogPage.getCatalogNavigationMenu().navigateToTechnicTypeCatalog(department, subdepartment, technicType);
    }
    
    @Given("Accept confidentiality agreement")
    public void acceptConfidentialityAgreement (){
        var catalogPage = new CatalogPage();
        catalogPage.acceptConfidentialityAgreement();
    }
}
