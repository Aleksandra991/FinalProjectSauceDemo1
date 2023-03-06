package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.example.pages.LoginPage;
import org.example.pages.ProductsPage;
import org.testng.internal.PropertyUtils;

public class LoginTests {
    @Test
    public void verifyLoginWithStandardUser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Korisnik\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();

        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.isOpen(), "Login failed");
        productsPage.close();


    }
}
