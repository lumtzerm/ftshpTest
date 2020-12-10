package testUtils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.exceptions.HtmlElementsException;

import java.time.Duration;

public class UtilsFactory {

    private static WebDriver driver;
    private static WebDriverWait driverWait = new WebDriverWait(getDriver(), 50);
    private static JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getDriver();
    private static Wait<WebDriver> wait = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(20))
            .pollingEvery(Duration.ofSeconds(1))
            .ignoring(HtmlElementsException.class);

    private static WebDriver startWebDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        return new ChromeDriver(options);
    }

    public static WebDriver getDriver(){
        if (driver == null) {
            driver = startWebDriver();
        }
        return driver;
    }

    public static Wait<WebDriver> getFluentWait() {
        return wait;
    }

    public static WebDriverWait getDriverWait() {
        return driverWait;
    }
    public static boolean isPageLoaded() {
        boolean isLoaded = false;
        if (javascriptExecutor.executeScript
                ("return document.readyState").toString().equals("complete")) {
            isLoaded = true;
        }
        return isLoaded;
    }

    public static boolean waitForJStoLoad() {

        WebDriverWait wait = new WebDriverWait(driver, 30);
        // wait for jQuery to load
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long)javascriptExecutor.executeScript("return jQuery.active") == 0);
                }
                catch (Exception e) {
                    return true;
                }
            }
        };
        // wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return javascriptExecutor.executeScript("return document.readyState")
                        .toString().equals("complete");
            }
        };
        return wait.until(jQueryLoad) && wait.until(jsLoad);
    }
}