package com.WebstaurantStore.Utilities;

import com.WebstaurantStore.Pages.MainPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {

    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void hoverAndClick(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).click().perform();;
    }
    public static void hover(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();;
    }

    public static List<String> findNonMatchingTitles(MainPage mainPage, String keyword) {
        // List to store titles that do not contain the keyword
        List<String> nonMatchingTitles = new ArrayList<>();

        // Iterate through all pages
        int totalPages = mainPage.paginationLinks.size();
        for (int currentPage = 0; currentPage < totalPages; currentPage++) {
            // Click the current page link
            mainPage.clickNextPage(currentPage);

            // Adjust wait time as needed, increase wait time if last page takes longer to load
            BrowserUtils.waitFor(3);

            // Log the current page number for debugging
            System.out.println("Checking page: " + (currentPage + 1) + " out of " + totalPages);

            // Check titles on the current page
            for (WebElement element : mainPage.searchResults) {
                String title = element.getText();
                // Log each title for debugging
                System.out.println("Checking title: " + title);

                // Check if the title contains the keyword
                if (!title.toLowerCase().contains(keyword.toLowerCase())) {
                    // Add the title to the list of non-matching titles
                    nonMatchingTitles.add(title);
                }
            }
        }

        // Print the list of titles that do not contain the keyword
        if (!nonMatchingTitles.isEmpty()) {
            System.out.println("Titles that do not contain the keyword '" + keyword + "':");
            for (String nonMatchingTitle : nonMatchingTitles) {
                System.out.println(nonMatchingTitle);
            }
        }

        return nonMatchingTitles;
    }


}
