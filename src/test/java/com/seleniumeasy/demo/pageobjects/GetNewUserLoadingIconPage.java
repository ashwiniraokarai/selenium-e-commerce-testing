package com.seleniumeasy.demo.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class GetNewUserLoadingIconPage extends PageObject {
    @FindBy(css = "#save")
    private WebElementFacade getNewUserButton;

    private By userDetailsContainer(){
        return By.cssSelector("#loading");
    }

    public void openNewUserLoadingIconPage() {
        openUrl("https://demo.seleniumeasy.com/dynamic-data-loading-demo.html");
    }

    public void openNewUserDetails() {
        getNewUserButton.click();
    }

    public String userDetailsPane() {
        return find(userDetailsContainer()).getText();
    }

    public void waitForLoadingStateToDisappear() {
        withTimeoutOf(Duration.ofSeconds(10))
                .waitFor(ExpectedConditions.invisibilityOfElementWithText(userDetailsContainer(), "loading..."));
    }

}
