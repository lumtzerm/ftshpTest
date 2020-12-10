package pageObjects;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;
import testUtils.UtilsFactory;

public class LandingPage {

    @FindBy(className = "SearchIcon_searchIcon_2rre5")
    public HtmlElement searchIcon;

    @FindBy(className = "Input_input_95e7J")
    public HtmlElement searchInput;

    @FindBy(className = "Search_iconContainer_2MkpU")
    public HtmlElement searchButton;


    private LandingPage() {
    }

    public static LandingPage getLandingPage() {
        LandingPage landingPage = new LandingPage();
        HtmlElementLoader.populatePageObject(landingPage, UtilsFactory.getDriver());
        return landingPage;
    }

    public void searchFor(String text){
        searchIcon.click();
        searchInput.sendKeys(text);
        searchButton.click();
    }
}

