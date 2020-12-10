package testUtils;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static testUtils.UtilsFactory.getDriver;

public class BasicTest {

    private static WebDriver driver;

    @Before
    public void startup() {

        // webDriver for chrome, version 87.0.4280.88
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/webdriver/chromedriver/chromedriver.exe");
        driver = getDriver();
        driver.get("https://www.footshop.sk");
        driver.findElement(By.className("CookieConsent_button_2ooNQ")).click();
    }
    @After
    public void cleanup(){
        driver.close();
    }

}
