package onliner.pageobjects.pageFragments.navMenus;


import framework.BaseFragment;
import framework.elements.Label;

public class TopNavigationBar extends BaseFragment {
    Label lblApplicatoinSection = new Label("//span[@class='b-main-navigation__text' and contains(text(),'%s')]");
    
    public void navigateToApplicatoinSection(String section) {
        lblApplicatoinSection.clickAndWait(section);
    }
}
