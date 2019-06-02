package com.manolopajaro.pages;

import com.manolopajaro.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class GoogleSearchResults extends BasePage {

    @FindBy(xpath = ".//div[h2[@class='bNg8Rb']]/div[1]")
    private WebElement result;

    GoogleSearchResults(WebDriver driver) {
        super(driver);
    }

    public void waitForResults() {
        waitFor(result);
    }

    public WebElement getFirstResult() {
        return result.findElement(By.cssSelector("a > h3"));
    }

    public void clickFirstResult() {
        WebElement firstResult = result.findElement(By.xpath(".//div[1]/a"));
        click(firstResult);
    }
}
