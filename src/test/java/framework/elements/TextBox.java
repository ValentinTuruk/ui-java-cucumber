package framework.elements;

public final class TextBox extends BaseElement {
    public TextBox(String xpathOfText) {
        super(xpathOfText);
    }
    
    private void waitAndScroll(String option) {
        waitForElementMiddleTime(option);
        scrollIntoView();
    }
    
    public void setValue(String option, String value) {
        waitAndScroll(option);
        hilightElement();
        element.sendKeys(value);
    }
    
    public void setValue(String option, int value) {
        waitAndScroll(option);
        hilightElement();
        element.sendKeys(String.valueOf(value));
    }
}
