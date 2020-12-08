package test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.LandingPage;
import pageObjects.SearchPage;
import testUtils.BasicTest;
import testUtils.UtilsFactory;

import static pageObjects.LandingPage.*;
import static pageObjects.SearchPage.*;

public class SimpleTestClass extends BasicTest {

    LandingPage landingPage;
    SearchPage searchPage;

    @Test
    public void simpleTest(){

//        landingPage = getLandingPage();
//        landingPage.searchFor("KARHU");
        searchPage = getSearchPage();

        searchPage.getSubCategoryByName("CM").getShowAllButton().click();
        searchPage.getSubCategoryByName("CM").getFilterCategoriesOption("29.7")
                .getFsCheckBoxBox().click();

        UtilsFactory.getDriverWait().until(ExpectedConditions.elementToBeClickable(searchPage.getDropDown())).click();
        searchPage.getDropDown().getDropDownOption("Najnižšia cena").click();



        System.out.print("tutacakam");
    }
}
