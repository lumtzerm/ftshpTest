package testUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilsFactory {

    private static WebDriver driver;
    private static WebDriverWait driverWait = new WebDriverWait(getDriver(), 20);

    private static WebDriver startWebDriver(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/webdriver/chromedriver/chromedriver.exe");
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

    public static WebDriverWait getDriverWait() {
        return driverWait;
    }
}
