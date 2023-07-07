package com.WebstaurantStore.Pages;

import com.WebstaurantStore.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage {
    public MainPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//div[contains(@class,'hidden flex-1 lt:flex')]//input[@id='searchval']")
    public WebElement searchBox;

    @FindBy(xpath ="//div[contains(@class,'hidden flex-1 lt:flex')]//button[contains(@value,'Search')]" )
    public WebElement searchButton;



    @FindBy(css = "span[data-testid='itemDescription']")
    public List<WebElement> searchResults;

    @FindBy(xpath = "//*[@id=\"paging\"]/nav/ul/li")
    public List<WebElement> allPages;
}
