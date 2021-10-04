package tests;

import org.junit.Test;
import page.CartFragment;
import page.HeaderFragment;
import page.ProductViewFragment;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;
import static page.BasePage.BASE_URL;

public class AddToCartTest extends BaseTest {

    /**
     * Test case 2:
     * Description: Product is added to cart with correct price.
     * Steps:
     * Open main page;
     * Click on type of food (e.g. Burger).
     * Click on "Add" button for Cheeseburger
     * Click on Pick up option
     * Click on "Submit" button
     * Expected result: Cheeseburger is shown in the cart with correct price.
     */
    @Test
    public void testProductIsAddedToCartWithCorrectPrice() {
        String productName = "Cheeseburger";
        HeaderFragment header = new HeaderFragment();
        ProductViewFragment productsList = new ProductViewFragment();
        CartFragment cart = new CartFragment();

        open(BASE_URL);
        header.clickOnMenuItem("Burger");
        productsList.addToCartProduct(productName);
        productsList.clickOnPickUpOptionInModal();
        productsList.clickOnSubmitButton();
        String priceFromMenu = productsList.getPriceFromSubmitButtonWithExtras();
        productsList.clickOnSubmitButtonWithExtras();
        String priceFromCart = cart.getProductCostFromCart(productName);
        assertEquals("Price is incorrect.", priceFromMenu, priceFromCart);
    }
}
