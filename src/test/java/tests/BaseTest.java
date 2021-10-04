package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {

    @Before
    public void setUp() {
        Configuration.browserCapabilities = new DesiredCapabilities();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        Configuration.browserCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
    }

    @After
    public void tearDown(){
        closeWebDriver();
    }

    public static boolean isTextShown(String text){
        return $(By.xpath(String.format("//body//*[contains(text(), '%s')]", text))).isDisplayed();
    }

    public static void clickOnElementWithText(String text){
        $(By.xpath(String.format("//*[text()='%s')]", text))).shouldBe(visible).click();
    }

}
