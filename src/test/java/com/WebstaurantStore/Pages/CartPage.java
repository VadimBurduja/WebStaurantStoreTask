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

    @FindBy(xpath = "//a[@class='btn btn-primary']")
    public WebElement CartButton;

    @FindBy(id = "buyButton")
    public WebElement addToCart;

   @FindBy(css = "footer[data-testid='modal-footer'] button.bg-green-500")
   public WebElement emptyButton;

    @FindBy(css = ".header-1")
    public WebElement cartEmptyMessage;

    public boolean isCartEmpty() {
        return cartEmptyMessage.isDisplayed();
    }
}
