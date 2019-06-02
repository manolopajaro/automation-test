package com.manolopajaro.pages;

import com.manolopajaro.pages.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleSearchPage extends BasePage {

    @FindBy(name = "q")
    private WebElement searchBox;

    @FindBy(name = "btnK")
    private WebElement searchButton;

    public GoogleSearchPage(WebDriver d) {
        super(d);
    }

    public GoogleSearchResults search(Object criteria) {
        type(searchBox, criteria.toString());
        return new GoogleSearchResults(getDriver());
    }

    public void clickSearch() {
        click(searchButton);
    }

    public GoogleSearchResults waitForResults() {
        GoogleSearchResults searchResults = new GoogleSearchResults(getDriver());
        searchResults.waitForResults();
        return searchResults;
    }

    public GoogleSearchSuggestionBox waitForSuggestions() {
        GoogleSearchSuggestionBox googleSearchSuggestionBox = new GoogleSearchSuggestionBox(getDriver());
        googleSearchSuggestionBox.waitForSuggestions();
        return googleSearchSuggestionBox;
    }
}
