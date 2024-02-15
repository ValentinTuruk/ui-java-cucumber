package onliner.pageobjects.pages;

import framework.BasePage;
import framework.elements.Button;
import onliner.pageobjects.pageFragments.navMenus.CatalogNavigationMenu;

public class CatalogPage extends BasePage {
    private static String xpathCatalogTitle = "//div[@class='catalog-navigation__title']";
    
    public CatalogPage() {
        super(xpathCatalogTitle);
        this.catalogNavigationMenu = new CatalogNavigationMenu();
    }
    
    private CatalogNavigationMenu catalogNavigationMenu;
    
    private Button btnAcceptConfidentialityAgreement = new Button("//button[contains(@aria-label, 'Соглашаюсь')]");
    
    public void acceptConfidentialityAgreement() {
        btnAcceptConfidentialityAgreement.clickAndWait();
    }
    
    public CatalogNavigationMenu getCatalogNavigationMenu() {
        return catalogNavigationMenu;
    }
}
