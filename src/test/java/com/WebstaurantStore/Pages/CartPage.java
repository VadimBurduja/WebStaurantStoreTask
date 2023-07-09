package com.WebstaurantStore.Pages;

import com.WebstaurantStore.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    public CartPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }



    @FindBy(css= ".emptyCartButton.btn.btn-mini.btn-ui.pull-right")
    public WebElement emptyCartButton;

    @FindBy(css = ".bg-gray-100.border-gray-300.border-solid.border-0.border-t button:nth-child(1)")
    public WebElement emptyCartAlertButton;

    @FindBy(css = ".group.flex.rounded-tl.rounded-bl.overflow-hidden span:nth-child(1)\n")
    public WebElement CartButton;

    @FindBy(css = ".add-to-cart")
    public WebElement addToCart;

    @FindBy(css = ".header-1")
    public WebElement cartEmptyMessage;

    public boolean isCartEmpty() {
        return cartEmptyMessage.isDisplayed();
    }
}
