package pageObjects;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.exceptions.HtmlElementsException;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;
import testUtils.UtilsFactory;

import java.util.List;

public class SearchPage {

    @FindBy(className = "MobileFilterCollectionContent_subcollection_2NMao")
    private List<FilterSubCategories> subCategories;

    @FindBy(className = "Dropdown_dropdown_3tKJH")
    private FsDropDown dropDown;

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

    public List<FilterSubCategories> getSubCategories () {
        return subCategories;
    }

    public FilterSubCategories getSubCategoryByName(String subCategoryName){
            return getSubCategories().stream().filter(subCategory ->
                    subCategory.getFilterTitle().getText().equals(subCategoryName))
                        .findFirst().orElseThrow(HtmlElementsException::new);
    }
}
