package com.manolopajaro.features.steps;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.junit.AfterClass;

public class HookSteps {

    @Managed
    WebDriverFacade driver;


    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
