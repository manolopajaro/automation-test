package com.manolopajaro.features.steps;

import com.manolopajaro.pages.GoogleSearchPage;
import com.manolopajaro.pages.GoogleSearchResults;
import com.manolopajaro.pages.GoogleSearchSuggestionBox;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.fluentlenium.core.annotation.Page;
import org.junit.Assert;

public class SearchSteps {

    @Managed
    WebDriverFacade driver;

    @Page
    GoogleSearchPage googlePage;

    @Page
    GoogleSearchResults googleSearchResultsPage;

    @Page
    GoogleSearchSuggestionBox googleSearchSuggestionBox;

    @Given("^The user is on the homepage$")
    public void im_in_the_homepage(){
        googlePage.openBrowser();
    }

    @When("^The user type \"([^\"]*)\" into the search field$")
    public void type_into_search_field(String searchCriteria) {
        googlePage.search(searchCriteria);
    }

    @And("^The user click the Google Search button$")
    public void i_click_on_search_button() {
        googlePage.clickSearch();
    }

    @And("^The user go to the search results page$")
    public void i_go_results_page() {
        googleSearchResultsPage = googlePage.waitForResults();
    }

    @Then("^the first result should be \"([^\"]*)\"$")
    public void the_first_result_should_be(String expectedFirstResult) {
        String firstResult = googleSearchResultsPage.getFirstResult().getText();
        Assert.assertEquals("First result is invalid. \nWas expecting: '"+expectedFirstResult+"' and found: '"+firstResult+"'", firstResult, expectedFirstResult);
    }

    @And("^The user clicks the first result$")
    public void click_first_result() {
        googleSearchResultsPage = googlePage.waitForResults();
        googleSearchResultsPage.clickFirstResult();
    }

    @Then("^The user should see the \"([^\"]*)\" page")
    public void should_see_expected_page(String expectedPageTitle) {
        String pageTitle = driver.getTitle();
        Assert.assertEquals("Invalid page. \nWas expecting page with title: '"+expectedPageTitle+"' and found: '"+pageTitle+"'", pageTitle, expectedPageTitle);
    }

    @And("^the suggestions list is displayed$")
    public void suggestion_list_displayed(){
        googleSearchSuggestionBox = googlePage.waitForSuggestions();
    }

    @And("^The user clicks on the first suggestion in the list$")
    public void click_first_suggestion() {
        googleSearchSuggestionBox.clickFirstSuggestion();
    }
}
