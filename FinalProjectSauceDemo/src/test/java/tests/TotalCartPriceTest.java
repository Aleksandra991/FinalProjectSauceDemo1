package tests;

import org.example.pages.ProductItem;
import org.example.pages.CheckoutPage;
import org.example.pages.ProductsPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.example.pages.LoginPage;

import java.util.LinkedList;
import java.util.List;

public class TotalCartPriceTest {

    @Test
    public void verifyTotalSumOfProducts() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Korisnik\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();

        ProductsPage productsPage = new ProductsPage(driver);
        List<ProductItem> productItems = new LinkedList<>();
        productItems.add(productsPage.addProductToCartByName("Sauce Labs Backpack"));
        productItems.add(productsPage.addProductToCartByName("Sauce Labs Bike Light"));

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.proceedToCheckoutPage("John", "Doe", "123");
        Double totalPrice = checkoutPage.getTotalPrice();

        Double totalPriceExpected = 0D;
        for (ProductItem productItem : productItems) {
            totalPriceExpected += Double.parseDouble(productItem.getPrice().replace("$", ""));
        }

        totalPriceExpected += checkoutPage.getTax();

        Assert.assertEquals(totalPriceExpected, totalPrice);

        checkoutPage.close();
    }
}