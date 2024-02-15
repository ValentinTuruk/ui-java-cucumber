package framework;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;
import java.util.Set;

import static framework.utils.PropertiesReader.getConfigProperty;

public final class Browser extends Setup {
    
    private static Duration middlePageUploadTime = Duration.ofSeconds(Long.valueOf(Objects.requireNonNull(getConfigProperty("middle.page.waiter"))));
    
    public static WebDriverWait getMiddlePageUploadTime() {
        return new WebDriverWait(driver, middlePageUploadTime);
    }
    
    public static void navigateTo(String urlName) {
        Duration middleWieter = Duration.ofSeconds(Long.valueOf(Objects.requireNonNull(getConfigProperty("middle.page.waiter"))));
        WebDriverWait wait = new WebDriverWait(driver, middleWieter);
        driver.get(getConfigProperty(urlName));
        wait.until((ExpectedCondition<Boolean>) webDriver -> {
            assert webDriver != null;
            return ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete");
        });
    }
    
    public static void cleanBrowser() {
        driver.manage().deleteAllCookies();
        if (driver instanceof JavascriptExecutor) {
            ((JavascriptExecutor) driver).executeScript("window.localStorage.clear();");
            ((JavascriptExecutor) driver).executeScript("window.sessionStorage.clear();");
        }
    }
    
    public static void refreshPage() {
        driver.navigate().refresh();
    }
    
    public static void switchTab() {
        Set<String> windowHandles = driver.getWindowHandles();
        windowHandles.remove(driver.getWindowHandle());
        String newTab = windowHandles.iterator().next();
        driver.switchTo().window(newTab);
        waitForPageToLoad();
    }
    
    public static void waitForPageToLoad() {
        getMiddlePageUploadTime().until((ExpectedCondition<Boolean>) webDriver -> {
            assert webDriver != null;
            String readyState = (String) ((JavascriptExecutor) webDriver).executeScript("return document.readyState");
            return "complete".equals(readyState);
        });
    }
}
