package onliner.pageobjects.pageFragments.navMenus;

import framework.BaseFragment;
import framework.elements.Label;

public class CatalogNavigationMenu extends BaseFragment {
    Label lblDepartmentOfCatalog = new Label("//span[@class='catalog-navigation-classifier__item-title-wrapper' and contains(text(),'%s')]");
    Label lblSubdepartmentOfCatalog = new Label("//div[@class='catalog-navigation-list__aside-title' and contains(text(),'%s')]");
    Label lblTechnicType = new Label("//div[contains(@class,'catalog-navigation-list__aside-item_active')]//span[@class='catalog-navigation-list__dropdown-title' and contains(text(),'%s')]/ancestor::a");
    
    public void navigateToTechnicTypeCatalog(String departmentName, String subdepartmentName, String technicType) {
        lblDepartmentOfCatalog.click(departmentName);
        lblSubdepartmentOfCatalog.click(subdepartmentName);
        lblTechnicType.clickAndWait(technicType);
    }
}
