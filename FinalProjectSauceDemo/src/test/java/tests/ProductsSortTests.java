package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.example.pages.LoginPage;
import org.example.pages.ProductsPage;


public class ProductsSortTests {
    @Test
    public void verifyProductsSortedFromAtoZ() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Korisnik\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.sortByValue("Name (A to Z)");

        boolean sortedByNameAtoZ = productsPage.verifyProductsSortedFromAtoZ();

        Assert.assertTrue(sortedByNameAtoZ, "Products are not sorted as expected, from A to Z");

        productsPage.close();
    }


    @Test
    public void verifyProductsSortedFromZtoA() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.sortByValue("Name (Z to A)");

        boolean isSortedByNameZtoA = productsPage.verifyProductsSortedFromZtoA();

        Assert.assertTrue(isSortedByNameZtoA, "Products are not sorted as expected, from Z to A");

        productsPage.close();
    }
}