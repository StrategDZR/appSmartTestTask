package page;

import org.openqa.selenium.By;

import java.util.Objects;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CartFragment extends BasePage {
    private final String PRODUCT_COST_FROM_CART_TEMPLATE = "//div[@class='product-name'][contains(text(), '%s')]" +
            "//..//..//..//div[@class='total-price']";

    public String getProductCostFromCart(String productName) {
        logger.info(String.format("Get price of '%s' from Cart."), productName);
        String locator = String.format(PRODUCT_COST_FROM_CART_TEMPLATE, productName);
        $(By.xpath(locator)).shouldBe(visible);
        return Objects.requireNonNull($(By.xpath(locator)).getAttribute("innerHTML")).replaceAll("[^0-9,]", "");
    }
}
