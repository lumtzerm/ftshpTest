package test;

import com.google.common.collect.Comparators;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.LandingPage;
import pageObjects.Product;
import pageObjects.SearchPage;
import testUtils.BasicTest;
import testUtils.UtilsFactory;

import java.util.Comparator;

import static org.assertj.core.api.Assertions.*;
import static pageObjects.LandingPage.getLandingPage;
import static pageObjects.SearchPage.getSearchPage;

public class SimpleTestClass extends BasicTest {

    private LandingPage landingPage;
    private SearchPage searchPage;

    /* This is a simple test based on my usage of footshop.sk
     * Test step:
     *  - navigate to footshop.sk and "accept" cookies
     *  - search for "KARHU"
     *  - select size based on length of foot (CM, 29.7)
     *  - sort products based on price, ascending
     *  - verify that products are sorted by price, ascending
     */

    @Test
    public void simpleTest(){

        Comparator <Product> byPrice = Comparator.comparing(Product::getPrice);
        landingPage = getLandingPage();
        landingPage.searchFor("KARHU");
        searchPage = getSearchPage();

        String subCategoryName = "CM";
        searchPage.getSubCategoryByName(subCategoryName).clickShowAllButton();
        String filterCategoryOption = "29.7";
        searchPage.getSubCategoryByName(subCategoryName).selectFilterCategoriesOption(filterCategoryOption);
        searchPage.waitTillSortDone();

        searchPage.selectDropDownOption("Najnižšia cena");
        searchPage.waitTillSortDone();

        // check that products are sorted by price, ascending

        searchPage.getProductWrapper().getProducts().forEach(product -> System.out.println(product.getPrice()));

        assertThat(Comparators.isInOrder(searchPage.getProductWrapper().getProducts(), byPrice))
                .isTrue();
    }
}
