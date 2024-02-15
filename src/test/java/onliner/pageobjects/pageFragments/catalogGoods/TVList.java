package onliner.pageobjects.pageFragments.catalogGoods;

import framework.BaseFragment;
import framework.elements.ListOfElements;
import framework.utils.SoftAsserts;

public class TVList extends BaseFragment {
    private ListOfElements lstDiscriptionOfSearchResultItem = new ListOfElements("//div[contains(@class,'offers-item_primary')]//div[contains(@class, 'parameter-flex')]");
    private ListOfElements lstPriceOfSearchResultItem = new ListOfElements("//div[contains(@class, 'offers-part_control')]/child::div/child::a[contains(@class, 'link')]");
    private ListOfElements lstTitleOfSearchResultItem = new ListOfElements("//div[contains(@class,'offers-item_primary')]//div[contains(@class,'offers-part_data')]//div[contains(@class, 'description_condensed-other') and contains(@class, 'description_primary')]");
    
    
    public void verifyTitleText(String textPart) {
        var elementsText = lstTitleOfSearchResultItem.getElementsText();
        for (String text : elementsText) {
            SoftAsserts.softAssert.assertTrue(text.contains(textPart), String.format("Title does not contain '%s' text", textPart));
        }
    }
    
    public void verifyResolution(String resolution) {
        var elementsText = lstDiscriptionOfSearchResultItem.getElementsText();
        for (String text : elementsText) {
            SoftAsserts.softAssert.assertTrue(text.contains(resolution), String.format("Description does not contain '%s' Resolution", resolution));
        }
    }
    
    public void verifyMinDiagonalSize(int min) {
        verifyDiagonalSize(min, 2_147_483_647);
    }
    
    public void verifyMaxDiagonalSize(int max) {
        verifyDiagonalSize(0, max);
    }
    
    private void verifyDiagonalSize(int min, int max) {
        var elementsText = lstDiscriptionOfSearchResultItem.getElementsText();
        for (String text : elementsText) {
            int elementText = Integer.valueOf(text.split("\"")[0]);
            SoftAsserts.softAssert.assertTrue(elementText >= min && elementText <= max, String.format("Diagonal is out of [%d,%d]", min, max));
        }
    }
    
    public void verifyMaxPrice(double max) {
        verifyPrice(0, max);
    }
    
    private void verifyPrice(double min, double max) {
        var elementsText = lstPriceOfSearchResultItem.getElementsText();
        for (String text : elementsText) {
            double elementText = Double.valueOf(text.split("\\.")[0].replaceAll("[^\\d,]+", "").replace(',', '.'));
            SoftAsserts.softAssert.assertTrue(elementText >= min && elementText <= max, String.format("Price is out of [%.2f,%.2f]", min, max));
        }
    }
}