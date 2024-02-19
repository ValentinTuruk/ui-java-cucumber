package onliner.pageobjects.pages;

import framework.BasePage;
import onliner.pageobjects.pageFragments.navMenus.TopNavigationBar;

public class HomePage extends BasePage {
    private static String xpathNewsContainer = "//div[@class='b-news-layer']";
    
    public HomePage() {
        super(xpathNewsContainer);
        this.topNavigationBar = new TopNavigationBar();
    }
    
    private TopNavigationBar topNavigationBar;
    
    public TopNavigationBar getTopNavigationBar() {
        return topNavigationBar;
    }
}
