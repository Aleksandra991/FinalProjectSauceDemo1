package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage {
    public WebDriver driver;

    public CartPage(WebDriver driver) {

        this.driver = driver;
    }

    public void openCart() {
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
    }

    public void close() {
        driver.close();
        driver.quit();
    }


    public boolean isProductInCart(ProductItem productItem) {

        WebElement cartList = driver.findElement(By.xpath("//div[@class='cart_list']"));

        List<WebElement> listItems = cartList.findElements(By.xpath(".//div[@class='cart_item']"));

        for (WebElement listItem : listItems) {
            WebElement name = listItem.findElement(By.xpath(".//div[@class='inventory_item_name']"));
            WebElement description = listItem.findElement(By.xpath(".//div[@class='inventory_item_desc']"));
            WebElement price = listItem.findElement(By.xpath(".//div[@class='inventory_item_price']"));
            if (name.getText().equals(productItem.getName()) && description.getText().equals(productItem.getDescription()) && price.getText().equals(productItem.getPrice())) {
                return true;
            }
        }
        return false;
    }

    public int getNumberOfItemsInCart() {
        WebElement cartList = driver.findElement(By.xpath("//div[@class='cart_list']"));

        List<WebElement> listItems = cartList.findElements(By.xpath(".//div[@class='cart_item']"));

        return listItems.size();
    }
}
