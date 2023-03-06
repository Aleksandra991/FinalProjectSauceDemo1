package tests;

import org.example.pages.ProductItem;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.example.pages.CartPage;
import org.example.pages.LoginPage;
import org.example.pages.ProductsPage;

public class VerifyProductsNameDescriptionPriceTest {
    @Test
    public void verifyAddProductToCartOnCartPage() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Korisnik\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();

        ProductsPage productsPage = new ProductsPage(driver);
        ProductItem productItem = productsPage.addProductToCartByName("Sauce Labs Bike Light");

        CartPage cartPage = new CartPage(driver);
        cartPage.openCart();
        Assert.assertEquals(1, cartPage.getNumberOfItemsInCart());
        Assert.assertTrue(cartPage.isProductInCart(productItem));

        cartPage.close();
    }
}