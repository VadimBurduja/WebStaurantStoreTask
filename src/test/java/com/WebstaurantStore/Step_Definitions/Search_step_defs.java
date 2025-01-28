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
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.security.Key;
import java.util.ArrayList;
import java.util.List;

public class Search_step_defs {
    MainPage mainPage = new MainPage();
    CartPage cartPage = new CartPage();

    @Given("Customer is on the webstauranstore homepage")
    public void customer_is_on_the_webstauranstore_homepage(){
        String expectedUrl = ConfigurationReader.getProperty("WebstaurantStoreUrl");
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);

    }
    @When("Customer search for the product {string}")
    public void customer_search_for_the_product(String product) {
        mainPage.searchBox.sendKeys(product);
        mainPage.searchBox.sendKeys(Keys.ENTER);

    }
    @Then("Customer should see the search results")
    public void customer_should_see_the_search_results() {
        boolean searchResultsIsDisplayed=mainPage.itemDescription.isDisplayed();
        System.out.println("searchResultsIsDisplayed = " + searchResultsIsDisplayed);


    }
    @Then("Verifies that all product titles contain the keyword {string}")
    public void verifies_that_all_product_titles_contain_the_keyword(String keyword) {

            List<String> nonMatchingTitles = BrowserUtils.findNonMatchingTitles(mainPage, keyword);

            if (!nonMatchingTitles.isEmpty()) {
                System.out.println("Some titles do not contain the keyword '" + keyword + "':");
                for (String title : nonMatchingTitles) {
                    System.out.println(title);
                }
                // Failing the test with detailed information
                Assert.fail("Some titles do not contain the keyword '" + keyword + "': " + nonMatchingTitles);
            } else {
                System.out.println("All titles contain the keyword '" + keyword + "'.");
            }


    }

    @Then("Customer adds the last of found items to Cart")
    public void customer_adds_the_last_of_found_items_to_cart() {
        WebElement lastItem = mainPage.searchResults.get(mainPage.searchResults.size()-1);
        lastItem.click();
        cartPage.addToCart.click();
        BrowserUtils.waitFor(2);

    }
    @Then("Customer empty the Cart")
    public void customer_empty_the_cart() {
        cartPage.CartButton.click();
        cartPage.emptyCartButton.click();
        BrowserUtils.hoverAndClick(cartPage.emptyButton);


    }
    @Then("Customer should see the {string}")
    public void customer_should_see_the(String emptyMessage) {
        System.out.println("cartEmptyMessage = " + cartPage.cartEmptyMessage.getText());
        Assert.assertTrue(emptyMessage, cartPage.isCartEmpty());
    }

}
