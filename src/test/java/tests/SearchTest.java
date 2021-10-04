package tests;

import org.junit.Test;
import page.HeaderFragment;
import page.ProductViewFragment;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;
import static page.BasePage.BASE_URL;

public class SearchTest extends BaseTest {

    /**
     * Test case 1
     * Description: Search works.
     * Steps:
     * 1. Open main page;
     * 2. Type "Carbonara" in search field.
     * Expected result: "Carbonara" is in search result.
     */
    @Test
    public void testCorrectSearch() {
        String searchCriteria = "Carbonara";
        HeaderFragment header = new HeaderFragment();
        ProductViewFragment productsList = new ProductViewFragment();

        open(BASE_URL);
        header.inputSearchString(searchCriteria);
        assertTrue(productsList.productIsOnThePage(searchCriteria));
    }

    /**
     * Test case 6
     * Description: Search by non-existing product works.
     * Steps:
     * Open main page;
     * Type "testtest" in search field.
     * Expected result: "Leider wurden keine Produkte gefunden." is shown.
     */
    @Test
    public void testSearchWithNoResults() {
        String searchCriteria = "testtest";
        String expectedMessage = "Leider wurden keine Produkte gefunden.";
        HeaderFragment header = new HeaderFragment();

        open(BASE_URL);
        header.inputSearchString(searchCriteria);
        assertTrue(isTextShown(expectedMessage));
    }

}
