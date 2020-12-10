package testUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.exceptions.HtmlElementsException;

import java.time.Duration;

public class UtilsFactory {

    private static WebDriver driver;
    private static final WebDriverWait driverWait = new WebDriverWait(getDriver(), 5);
    private static final Wait<WebDriver> wait = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(20))
            .pollingEvery(Duration.ofSeconds(1))
            .ignoring(HtmlElementsException.class);

    private static WebDriver startWebDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        return new ChromeDriver(options);
    }

    public static WebDriver getDriver() {
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
}