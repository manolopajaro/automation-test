package com.manolopajaro.pages;

import com.manolopajaro.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class GoogleSearchResults extends BasePage {

    @FindBy(xpath = ".//div[h2[@class='bNg8Rb']]/div/div[@class='g']")
    private List<WebElement> result;

    @FindBy(xpath = ".//span[@class = 'gL9Hy']")
    private WebElement showingResultsForLabel;

    public GoogleSearchResults(WebDriver driver) {
        super(driver);
    }

    public void waitForResults() {
        waitFor(result.get(0));
    }

    public WebElement getFirstResult() {
        return result.get(0).findElement(By.cssSelector("a > h3"));
    }

    public List<WebElement> getResults(){
        return this.result;
    }

    public void clickFirstResult() {
        WebElement firstResult = result.get(0).findElement(By.xpath(".//div[1]/a"));
        click(firstResult);
    }

    public boolean isLabelShowingResultsForDisplayed() {
        boolean isDisplayed;
        try{
            isDisplayed = showingResultsForLabel.isDisplayed();
        }catch(ElementNotVisibleException e){
            isDisplayed = false;
        }
        return isDisplayed;
    }
}
