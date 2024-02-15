package framework;

import framework.elements.BaseElement;

import static framework.utils.PropertiesReader.getConfigProperty;

public abstract class BasePage extends Setup {
    public BasePage(String xpathPrimaryElement) {
        BaseElement.checkBasePageElement(xpathPrimaryElement);
    }
    
    public boolean checkAgeControlPageOpened() {
        String currentUrl = driver.getCurrentUrl();
        return currentUrl.contains(getConfigProperty("ageControl.urlPart"));
    }
}
