package page;

import org.openqa.selenium.By;

import java.util.Objects;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ProductViewFragment extends BasePage {
    private final String PRODUCT_NAME_TEMPLATE = "//div[@class='productNameWrap']/h5[contains(text(), '%s')]";
    private final String ADD_PRODUCT_BUTTON_TEMPLATE = "//div[@class='productNameWrap']" +
            "/h5[contains(text(), '%s')]/../..//..//..//div[@qa-data='add-to-cart-btn']";
    private final By PRODUCT_BLOCK = By.xpath("//div[@qa-data='product']");
    private final By ACTIVE_SUBMIT_WITHOUT_PRICE_BUTTON = By.xpath("//button[not(contains(class, 'disabled'))][@type='submit']");
    private final By ACTIVE_SUBMIT_WITH_PRICE_BUTTON = By.xpath("//button[@type='submit'][@qa-data='extras-order-btn']");
    private final By PICKUP_OPTION_IN_MODAL = By.xpath("//div[@class='ant-modal-body']//div[text()='Abholen']");

    public boolean productIsOnThePage(String productName) {
        logger.info(String.format("Check that '%s' product is displayed on the page."), productName);
        $(PRODUCT_BLOCK).shouldBe(visible);
        return $(By.xpath(String.format(PRODUCT_NAME_TEMPLATE, productName))).isDisplayed();
    }

    public void addToCartProduct(String productName) {
        logger.info(String.format("Click on Add to Cart button for '%s' product."), productName);
        $(By.xpath(String.format(PRODUCT_NAME_TEMPLATE, productName))).shouldBe(visible);
        $(By.xpath(String.format(ADD_PRODUCT_BUTTON_TEMPLATE, productName))).shouldBe(visible).click();
    }

    public void clickOnSubmitButton() {
        logger.info("Click on Submit button.");
        $(ACTIVE_SUBMIT_WITHOUT_PRICE_BUTTON).shouldBe(visible).click();
    }

    public void clickOnSubmitButtonWithExtras() {
        logger.info("Click on Submit button with extras.");
        $(ACTIVE_SUBMIT_WITH_PRICE_BUTTON).shouldBe(visible).click();
    }

    public String getPriceFromSubmitButtonWithExtras() {
        logger.info("Get price from Submit button with extras.");
        $(ACTIVE_SUBMIT_WITH_PRICE_BUTTON).shouldBe(visible);
        return Objects.requireNonNull($(ACTIVE_SUBMIT_WITH_PRICE_BUTTON).getAttribute("innerHTML")).replaceAll("[^0-9,]", "");
    }

    public void clickOnPickUpOptionInModal() {
        logger.info("Click on Pick up option in modal.");
        $(PICKUP_OPTION_IN_MODAL).shouldBe(visible).click();
    }
}
