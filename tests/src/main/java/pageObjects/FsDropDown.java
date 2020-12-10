package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.exceptions.HtmlElementsException;
import testUtils.UtilsFactory;

import java.util.List;

public class FsDropDown extends HtmlElement {

    @FindBy(className = "Dropdown_item_3d-b-")
    private List<HtmlElement> dropDownOptions;

    @FindBy(className = "Dropdown_activeItem_LAVaT")
    private HtmlElement selectedDropDown;

    public FsDropDown() {
    }

    public List<HtmlElement> getDropDownOptions() {
        return dropDownOptions;
    }

    public HtmlElement getSelectedDropDown() {
        return selectedDropDown;
    }

    public HtmlElement getDropDownOption(String dropDownOptionName) {
        return dropDownOptions.stream().filter(dropDownOption -> dropDownOption.getText().equals(dropDownOptionName))
                .findFirst().orElseThrow(HtmlElementsException::new);
    }

}
