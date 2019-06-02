package com.manolopajaro.pages;

import com.manolopajaro.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GoogleSearchSuggestionBox extends BasePage {

    @FindBy(className = "UUbT9")
    private WebElement suggestionList;

    public GoogleSearchSuggestionBox(WebDriver driver) {
        super(driver);
    }

    public void waitForSuggestions() {
        waitFor(ExpectedConditions.visibilityOf(suggestionList));
    }

    public void clickFirstSuggestion() {
        WebElement firstSuggestion = suggestionList.findElement(By.xpath(".//li[1]"));
        click(firstSuggestion);
    }
}
