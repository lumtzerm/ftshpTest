package pageObjects;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

public class Product extends HtmlElement{

    @FindBy(xpath = ".//meta[@itemprop='price']")
    HtmlElement price;

    @FindBy(xpath = ".//meta[@itemprop='price']")
    HtmlElement name;

    public Product() {
    }

    public double getPrice() {
        return Double.parseDouble(price.getAttribute("content"));
    }

    public String getProductName() {
        return name.getAttribute("content");
    }
}