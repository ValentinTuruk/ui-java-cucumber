package onliner.pageobjects.pages;

import framework.BasePage;
import onliner.pageobjects.pageFragments.catalogFilters.TVFilters;
import onliner.pageobjects.pageFragments.catalogGoods.TVList;

public class TVListPage extends BasePage {
    private static String xpathPageTitle = "//h1[contains(text(),'Телевизоры')]";
    
    public TVListPage() {
        super(xpathPageTitle);
        this.tvFilters = new TVFilters();
        this.tvList = new TVList();
    }
   
    TVFilters tvFilters;
    TVList tvList;
    
    public TVFilters getTvFilters() {
        return tvFilters;
    }
    
    public TVList getTvList() {
        return tvList;
    }
}
