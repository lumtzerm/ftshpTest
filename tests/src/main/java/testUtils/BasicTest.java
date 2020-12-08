package testUtils;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasicTest {
    // Basic test class
    private static WebDriver driver;

    @Before
    public void startup() {
        driver = UtilsFactory.getDriver();

        //driver.get("https://www.footshop.sk");

        driver.get("https://www.footshop.sk/sk/102_karhu");
        driver.findElement(By.className("CookieConsent_button_2ooNQ")).click();
    }
    @After
    public void cleanup(){
        driver.close();
    }

}
