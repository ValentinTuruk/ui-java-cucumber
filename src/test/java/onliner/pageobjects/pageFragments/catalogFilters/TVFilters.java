package onliner.pageobjects.pageFragments.catalogFilters;

import framework.BaseFragment;
import framework.elements.CheckBox;
import framework.elements.Dropdown;
import framework.elements.TextBlock;
import framework.elements.TextBox;

public class TVFilters extends BaseFragment {
    private CheckBox chkVendorFilter = new CheckBox("//div[@class='catalog-form__checkbox-sign' and  text()='%s']");
    private TextBlock tblFitlerResultsInProgress = new TextBlock("//div[@class='catalog-form__offers catalog-form__offers_processing']");
    private TextBlock tblFitlerResultsFinished = new TextBlock("//div[@class='catalog-form__offers']");
    private TextBox txtPriceFilter = new TextBox("//input[contains(@placeholder, '%s')]");
    private CheckBox chkResolutionFilter = new CheckBox("//div[@class='catalog-form__checkbox-sign' and  text()='%s']");
    private Dropdown ddwDiagonalFilter = new Dropdown("(//div[@class='catalog-form__label-title' and contains(.,'Диагональ')]/ancestor::div[contains(@class,'catalog-form__label_specific')]/following-sibling::div//select)[%s]");
    
    private void waitForFiltering() {
        tblFitlerResultsInProgress.waitForElementMiddleTime();
        tblFitlerResultsFinished.waitForElementMiddleTime();
    }
    
    public void setVendor(String vendor) {
        chkVendorFilter.click(vendor);
        waitForFiltering();
    }
    
    public void setMaxPrice(String price) {
        setPriceLimit("max", price);
    }
    
    private void setPriceLimit(String limitType, String price) {
        switch (limitType) {
            case "min" -> limitType = "от";
            case "max" -> limitType = "до";
            default -> System.out.println("Invalid limit type!");
        }
        txtPriceFilter.setValue(limitType, price);
    }
    
    public void setResolution(String resolution) {
        chkResolutionFilter.click(resolution);
        waitForFiltering();
    }
    
    public void setMinDiagonal(String diagonal) {
        setDiagonalLimit("min", diagonal);
    }
    
    public void setMaxDiagonal(String diagonal) {
        setDiagonalLimit("max", diagonal);
    }
    
    private void setDiagonalLimit(String limitType, String diagonal) {
        switch (limitType) {
            case "min" -> limitType = "1";
            case "max" -> limitType = "2";
            default -> System.out.println("Invalid limit type!");
        }
        ddwDiagonalFilter.setValue(limitType, diagonal + "\"");
        waitForFiltering();
    }
}
