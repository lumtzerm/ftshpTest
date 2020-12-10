package test;

import com.google.common.collect.Comparators;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import pageObjects.LandingPage;
import pageObjects.Product;
import pageObjects.SearchPage;
import testUtils.BasicTest;
import testUtils.UtilsFactory;

import java.util.Comparator;

import static pageObjects.LandingPage.getLandingPage;
import static pageObjects.SearchPage.getSearchPage;


public class SimpleTestClass extends BasicTest {

    String subCategoryName = "CM";
    String filterCategoryOption = "29.7";

    LandingPage landingPage;
    SearchPage searchPage;

    @Test
    public void simpleTest(){

        landingPage = getLandingPage();
        landingPage.searchFor("KARHU");
        searchPage = getSearchPage();

        searchPage.getSubCategoryByName(subCategoryName).clickShowAllButton();
        searchPage.getSubCategoryByName(subCategoryName).selectFilterCategoriesOption(filterCategoryOption);

        searchPage.selectDropDownOption("Najnižšia cena");

        // check that products are sorted by price, ascending
        Comparator <Product> byPrice = Comparator.comparing(Product::getPrice);
        searchPage.getProductWrapper().getProducts().forEach(product -> System.out.println(product.getPrice()));
        Assertions.assertThat(Comparators.isInOrder(searchPage.getProductWrapper().getProducts(), byPrice))
                .isTrue();
    }
}
