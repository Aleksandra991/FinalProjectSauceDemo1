package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckoutPage {
    public WebDriver driver;

    public CheckoutPage(ChromeDriver driver) {

        this.driver = driver;
    }

    private void setFirstName(String firstName) {
        driver.findElement(By.xpath("//*[@id=\"first-name\"]")).sendKeys(firstName);
    }

    private void setLastName(String lastName) {
        driver.findElement(By.xpath("//*[@id=\"last-name\"]")).sendKeys(lastName);
    }

    private void setZipCode(String zipCode) {
        driver.findElement(By.xpath("//*[@id=\"postal-code\"]")).sendKeys(zipCode);
    }

    private void clickContinue(String firstName) {
        driver.findElement(By.name("continue")).click();
    }

    public void proceedToCheckoutPage(String firstName, String lastName, String zipCode) {
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        driver.findElement(By.className("checkout_button")).click();

        setFirstName(firstName);
        setLastName(lastName);
        setZipCode(zipCode);

        driver.findElement(By.className("submit-button")).click();
    }

    public Double getTotalPrice() {
        WebElement webElement = driver.findElement(By.className("summary_total_label"));
        return Double.parseDouble(webElement.getText().replace("Total: $", ""));
    }

    public Double getTax() {
        WebElement webElement = driver.findElement(By.className("summary_tax_label"));
        return Double.parseDouble(webElement.getText().replace("Tax: $", ""));
    }

    public void close() {
        driver.close();
        driver.quit();
    }
}


