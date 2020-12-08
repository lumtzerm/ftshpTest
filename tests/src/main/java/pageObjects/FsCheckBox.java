package pageObjects;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

public class FsCheckBox extends HtmlElement {

    @FindBy(className = "FilterCollectionItem_checkbox_3HZZS")
    HtmlElement fsCheckBoxBox;

    public FsCheckBox() {
    }

    public HtmlElement getFsCheckBoxBox() {
        return fsCheckBoxBox;
    }
}
