package com.WebstaurantStore.Pages;

import com.WebstaurantStore.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    public CartPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }



    @FindBy(xpath= "//button[normalize-space()='Empty Cart']")
    public WebElement emptyCartButton;

    @FindBy(css = ".bg-gray-100.border-gray-300.border-solid.border-0.border-t button:nth-child(1)")
    public WebElement emptyCartAlertButton;

    @FindBy(xpath = "//a[@class='btn btn-primary']")
    public WebElement CartButton;

    @FindBy(id = "buyButton")
    public WebElement addToCart;

    @FindBy(css = ".header-1")
    public WebElement cartEmptyMessage;

    public boolean isCartEmpty() {
        return cartEmptyMessage.isDisplayed();
    }
}
