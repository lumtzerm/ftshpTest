package testUtils;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static testUtils.UtilsFactory.*;

public class BasicTest {
    // Basic test class
    private static WebDriver driver;

    @Before
    public void startup() {

        //change to webdriver location
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/webdriver/chromedriver/chromedriver.exe");

        driver = getDriver();

        driver.get("https://www.footshop.sk");

//        driver.get("https://www.footshop.sk/sk/102_karhu");
        driver.findElement(By.className("CookieConsent_button_2ooNQ")).click();
    }
    @After
    public void cleanup(){
        driver.close();
    }

}
