package com.WebstaurantStore.Pages;

import com.WebstaurantStore.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    public CartPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//button[normalize-space()='Empty Cart']")
    public WebElement emptyCartButton;

    @FindBy(xpath = "//button[normalize-space()='View Cart']")
    public WebElement viewCartButton;

    @FindBy(css = ".add-to-cart")
    public WebElement addToCart;

    @FindBy(xpath = "//button[contains(text(),'Empty Cart')]")
    public WebElement emptyCartAlertButton;
}
