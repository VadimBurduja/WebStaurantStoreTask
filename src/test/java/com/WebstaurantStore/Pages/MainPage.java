package com.WebstaurantStore.Pages;

import com.WebstaurantStore.Utilities.BrowserUtils;
import com.WebstaurantStore.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage {
    public MainPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//div[@class='hidden flex-1 ml-0 lt:flex max-w-[900px]']//input[@id='searchval']")
    public WebElement searchBox;
//
//    @FindBy(xpath ="//div[contains(@class,'hidden flex-1 lt:flex')]//button[contains(@value,'Search')]" )
//    public WebElement searchButton;



    @FindBy(css = "span[data-testid='itemDescription']")
    public List<WebElement> searchResults;

//    @FindBy(xpath = "//*[@id=\"paging\"]/nav/ul/li")//xpath = "//*[@id=\"paging\"]/nav/ul/li"
//    public List<WebElement> allPages;
@FindBy(css = "nav[aria-label='pagination'] ul li a")
public List<WebElement> paginationLinks;

    @FindBy(css = "span[data-testid='itemDescription']")
    public WebElement itemDescription;

//    public List<WebElement> getAllPages() {
//        // Return a list of WebElements representing pages
//        // You need to replace the locator with your actual locator
//        return Driver.getDriver().findElements(By.xpath("//*[@id=\"paging\"]/nav/ul/li"));
//    }
//    public List<WebElement> getSearchResults() {
//        // Replace with the actual locator for search results in your application
//        return Driver.getDriver().findElements(By.cssSelector("span[data-testid='itemDescription']"));
//    }
public void clickNextPage(int pageIndex) {
    if (pageIndex < paginationLinks.size()) {
        paginationLinks.get(pageIndex).click();
    }
}
}




