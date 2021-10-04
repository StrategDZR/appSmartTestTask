package page;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class HeaderFragment extends BasePage{
    private final By SEARCH_INPUT = By.xpath("//input[@qa-data='input-search']");
    private final String MENU_ITEM_TEMPLATE = "//div[@id='category-menu-desktop-hermes-theme']//span[text()='%s']";

    public void inputSearchString(String search) {
        logger.info("Input search string: " + search);
        $(SEARCH_INPUT).shouldBe(visible).click();
        $(SEARCH_INPUT).clear();
        $(SEARCH_INPUT).sendKeys(search);
    }

    public void clickOnMenuItem(String menuName) {
        logger.info(String.format("Click %s on menu item", menuName));
        $(By.xpath(String.format(MENU_ITEM_TEMPLATE, menuName))).shouldBe(visible).click();
    }
}
