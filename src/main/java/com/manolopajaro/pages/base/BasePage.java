package com.manolopajaro.pages.base;

import com.manolopajaro.core.Logging;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage extends PageObject implements Logging {

    public BasePage(WebDriver driver) {
        super(driver);
        getLogger().info(getClass().getSimpleName() + " opened");
    }

    public void openBrowser(){
        open();
    }

    public WebDriver getDriver() {
        return super.getDriver();
    }

    protected void type(WebElement element, String text){
        typeInto(element, text);
    }

    protected void click(WebElement element) {
        clickOn(element);
    }

    protected void click(By elementLocator) {
        super.clickOn(find(elementLocator));
    }

    protected void type(By elementLocator, String text) {
        super.typeInto(find(elementLocator), text);
    }
}
