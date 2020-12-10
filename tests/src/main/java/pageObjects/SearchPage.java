package pageObjects;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.exceptions.HtmlElementsException;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;
import testUtils.UtilsFactory;

import java.util.List;

public class SearchPage {

    @FindBy(className = "GridFilterSelectedTokens_wrapper_3PVJh")
    private SelectedFilters selectedFilters;

    @FindBy(className = "MobileFilterCollectionContent_subcollection_2NMao")
    private List<FilterSubCategories> subCategories;

    public SelectedFilters getSelectedFilters() {
        return selectedFilters;
    }

    @FindBy(className = "Dropdown_dropdown_3tKJH")
    private FsDropDown dropDown;

    @FindBy(className = "Products_wrapper_18Efi")
    private ProductWrapper productWrapper;

    private SearchPage() {
    }
    public static SearchPage getSearchPage() {
        SearchPage searchPage = new SearchPage();
        HtmlElementLoader.populatePageObject(searchPage, UtilsFactory.getDriver());
        return searchPage;
    }

    public FsDropDown getDropDown() {
        return dropDown;
    }

    public ProductWrapper getProductWrapper() {
        return productWrapper;
    }

    public void selectDropDownOption(String dropDownOptionName) {
        UtilsFactory.getFluentWait().until(driver -> getDropDownOption("Najnižšia cena"));
        dropDown.getDropDownOption(dropDownOptionName).click();
    }

    public HtmlElement getDropDownOption(String dropDownOptionName){
        dropDown.click();
        return dropDown.getDropDownOption(dropDownOptionName);
    }

    public List<FilterSubCategories> getSubCategories () {
        return subCategories;
    }

    public FilterSubCategories getSubCategoryByName(String subCategoryName){
            return getSubCategories().stream().filter(subCategory ->
                    subCategory.getFilterTitle().getText().equals(subCategoryName))
                        .findFirst().orElseThrow(HtmlElementsException::new);
    }
}
