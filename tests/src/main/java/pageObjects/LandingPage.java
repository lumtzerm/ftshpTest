package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testUtils.UtilsFactory;

public class LandingPage {

    @FindBy(className = "SearchIcon_searchIcon_2rre5")
    public WebElement searchIcon;

    @FindBy(className = "Input_input_95e7J")
    public WebElement searchInput;

    @FindBy(className = "Search_iconContainer_2MkpU")
    public WebElement searchButton;


    private LandingPage() {
    }
    public static LandingPage getLandingPage() {
        LandingPage landingPage = new LandingPage();
        PageFactory.initElements(UtilsFactory.getDriver(), landingPage);
        return landingPage;
    }

    public void searchFor(String text){
        searchIcon.click();
        searchInput.sendKeys(text);
        searchButton.click();
    }



}

