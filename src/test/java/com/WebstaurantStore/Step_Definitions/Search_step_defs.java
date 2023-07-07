package com.WebstaurantStore.Step_Definitions;

import com.WebstaurantStore.Pages.CartPage;
import com.WebstaurantStore.Pages.MainPage;
import com.WebstaurantStore.Utilities.BrowserUtils;
import com.WebstaurantStore.Utilities.ConfigurationReader;
import com.WebstaurantStore.Utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class Search_step_defs {
    MainPage mainPage = new MainPage();
    CartPage cartPage = new CartPage();

    @Given("I am on the webstauranstore homepage")
    public void i_am_on_the_webstauranstore_homepage() {
        String expectedUrl = ConfigurationReader.getProperty("WebstaurantStoreUrl");
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);

    }
    @When("I search for the product {string}")
    public void i_search_for_the_product(String product) {
        mainPage.searchBox.sendKeys(product);
        mainPage.searchButton.click();

    }
    @Then("I should see the search results")
    public void i_should_see_the_search_results() {
        boolean searchResultsIsDisplayed=Driver.getDriver().findElement(By.cssSelector("span[data-testid='itemDescription']")).isDisplayed();
        System.out.println("searchResultsIsDisplayed = " + searchResultsIsDisplayed);


    }
    @Then("I verify that all product titles contain the keyword {string}")
    public void i_verify_that_all_product_titles_contain_the_keyword(String keyword) {
        List<String> titles = new ArrayList<>();
        int currentPage = 1;

        while (currentPage<= mainPage.allPages.size()) {
            System.out.println("Checking titles on page " + currentPage);
            System.out.println("Number of search results: " + mainPage.searchResults.size());


            for (WebElement element : mainPage.searchResults) {
                String title = element.getText();
                System.out.println("Title: " + title);
                titles.add(title);
            }

            if (currentPage==mainPage.allPages.size()) {
                break;
            }
            mainPage.allPages.get(currentPage).click();
            currentPage++;
        }
        boolean isKeywordFound = titles.stream().anyMatch(title -> title.contains(keyword));
        Assert.assertTrue("At least one title contains the keyword: " + keyword, isKeywordFound);
    }


    @Then("Add the last of found items to Cart")
    public void add_the_last_of_found_items_to_cart() {
        WebElement lastItem = mainPage.searchResults.get(mainPage.searchResults.size()-1);
        lastItem.click();
        cartPage.addToCart.click();
        BrowserUtils.waitFor(10);

    }
    @Then("Empty the Cart")
    public void empty_the_cart() {
        cartPage.viewCartButton.click();
        cartPage.emptyCartButton.click();

        Actions act =  new Actions(Driver.getDriver());
        act.moveToElement(cartPage.emptyCartAlertButton).click().perform();
    }

}
