package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginPage
{

    public WebDriver driver;


    public LoginPage( ChromeDriver driver )
    {
        this.driver = driver;
    }


    public WebElement inputUsername()
    {
        return driver.findElement( By.xpath( "//input[@id='user-name']" ) );
    }


    public WebElement inputPassword()
    {
        return driver.findElement( By.id( "password" ) );
    }


    public WebElement buttonLogin()
    {

        return driver.findElement( By.name( "login-button" ) );
    }


    public void openPage()
    {

        driver.get( "https://www.saucedemo.com/" );
    }


    public void setUserName( String userName )
    {

        inputUsername().sendKeys( userName );
    }


    public void setPassword( String password )
    {

        inputPassword().sendKeys( password );
    }


    public void clickLogin()
    {
        driver.findElement( By.name( "login-button" ) ).click();
    }
}
