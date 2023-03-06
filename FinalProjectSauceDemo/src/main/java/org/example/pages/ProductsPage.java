package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ProductsPage {
    public WebDriver driver;

    public ProductsPage(ChromeDriver driver) {

        this.driver = driver;
    }

    public boolean isOpen() {
        String url = driver.getCurrentUrl();

        return url.equals("https://www.saucedemo.com/inventory.html");
    }

    public void close() {
        driver.close();
        driver.quit();

    }

    public boolean verifyProductsSortedFromAtoZ() {

        WebElement container = driver.findElement(By.id("inventory_container"));

        List<WebElement> listInventoryItems = container.findElements(By.xpath(".//div[@class='inventory_item']"));

        for (int i = 1; i < listInventoryItems.size(); i++) {
            WebElement secondItem = listInventoryItems.get(i).findElement(By.xpath(".//div[@class='inventory_item_name']"));
            WebElement firstItem = listInventoryItems.get(i - 1).findElement(By.xpath(".//div[@class='inventory_item_name']"));


            if (firstItem.getText().compareTo(secondItem.getText()) > 0) {
                return false;
            }
        }

        return true;
    }

    public boolean verifyProductsSortedFromZtoA() {

        WebElement container = driver.findElement(By.id("inventory_container"));

        List<WebElement> listInventoryItems = container.findElements(By.xpath(".//div[@class='inventory_item']"));

        for (int i = 1; i < listInventoryItems.size(); i++) {
            WebElement secondItem = listInventoryItems.get(i).findElement(By.xpath(".//div[@class='inventory_item_name']"));
            WebElement firstItem = listInventoryItems.get(i - 1).findElement(By.xpath(".//div[@class='inventory_item_name']"));


            if (firstItem.getText().compareTo(secondItem.getText()) < 0) {
                return false;
            }
        }

        return true;
    }


    public void sortByValue(String sortValue) {
        WebElement sortContainer = driver.findElement(By.xpath("//select[@data-test='product_sort_container']"));

        sortContainer.click();

        List<WebElement> options = sortContainer.findElements(By.xpath(".//option"));

        for (WebElement option : options) {
            String optionText = option.getText();
            if (optionText.equals(sortValue)) {
                option.click();
                break;
            }
        }

    }


    public ProductItem addProductToCartByName(String productName) {

        List<WebElement> listItems = driver.findElements(By.xpath(".//div[@class='inventory_item']"));

        for (WebElement listItem : listItems) {
            WebElement name = listItem.findElement(By.xpath(".//div[@class='inventory_item_name']"));
            WebElement description = listItem.findElement(By.xpath(".//div[@class='inventory_item_desc']"));
            WebElement price = listItem.findElement(By.xpath(".//div[@class='inventory_item_price']"));
            if (name.getText().equals(productName)) {
                listItem.findElement(By.tagName("button")).click();
                return new ProductItem(name.getText(), description.getText(), price.getText());
            }
        }

        return null;
    }

}

