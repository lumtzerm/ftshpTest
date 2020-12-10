package pageObjects;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.exceptions.HtmlElementsException;

import java.util.List;

public class SelectedFilters extends HtmlElement {

    @FindBy(className = "GridFilterSelectedToken_wrapper_gTvfm")
    private List<HtmlElement> selectedFilterList;

    public SelectedFilters() {
    }

    public List<HtmlElement> getSelectedFilterList() {
        return selectedFilterList;
    }

    public HtmlElement getSelectedFilter(String selectedFilterName){
        return selectedFilterList.stream().filter(selectedFilter -> selectedFilter.getText()
                .equals(selectedFilterName)).findFirst().orElseThrow(HtmlElementsException::new);
    }
}
