package pageObjects;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.util.List;

public class ProductWrapper extends HtmlElement {

    @FindBy(className = "Products_product_2PyWG")
    List<Product> productList;

    public ProductWrapper() {
    }

    public List<Product> getProducts() {
        return productList;
    }
}
