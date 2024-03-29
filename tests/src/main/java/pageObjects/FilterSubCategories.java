package pageObjects;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.exceptions.HtmlElementsException;

import java.util.List;

public class FilterSubCategories extends HtmlElement{

    @FindBy(className = "MobileFilterCollectionContent_title_2g73I")
    private HtmlElement subCategoryTitle;

    @FindBy(className = "FilterCollectionItem_wrapper_2x0F2")
    private List<FsCheckBox> subCategoryOptions;

    @FindBy(className = "ShowAll_button_3hSMq")
    private HtmlElement showAllButton;

    public FilterSubCategories() {
    }

    public HtmlElement getFilterTitle() {
        return subCategoryTitle;
    }

    public List<FsCheckBox> getFilterCategoriesOptions() {
        return subCategoryOptions;
    }

    public FsCheckBox getFilterCategoriesOption(String filterCategoryOption) {
        return subCategoryOptions.stream().filter(subCategoryOption -> subCategoryOption.getText()
                .substring(0, subCategoryOption.getText().indexOf(' '))
                .contains(filterCategoryOption)).findFirst().orElseThrow(HtmlElementsException::new);
    }

    public void selectFilterCategoriesOption(String filterCategoryOption) {
        FsCheckBox fsCheckBox = subCategoryOptions.stream().filter(subCategoryOption -> subCategoryOption.getText()
                .substring(0, subCategoryOption.getText().indexOf(' '))
                .contains(filterCategoryOption)).findFirst().orElseThrow(HtmlElementsException::new);

        fsCheckBox.getFsCheckBoxBox().click();
    }

    public HtmlElement getShowAllButton() {
        return showAllButton;
    }

    public void clickShowAllButton() {
        showAllButton.click();
    }
}
