package com.seleniumeasy.demo.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class AlertPage extends PageObject {
    @FindBy(css = ".alert-autocloseable-success")
    public WebElementFacade autoCloseableAlertBox;

    @FindBy(css = "#autoclosable-btn-success")
    private WebElementFacade autoCloseableAlertTriggerButton;
    public void openAlertPage(){
        openUrl("https://demo.seleniumeasy.com/bootstrap-alert-messages-demo.html");
    }

    public void openAutoCloseableSuccessAlertBox() {
        autoCloseableAlertTriggerButton.click();
    }
    public String message() {
       return autoCloseableAlertBox.getText();
    }

    public void waitForMessageToDisappear(String expectedAlertMessage) {
            waitForTextToDisappear(expectedAlertMessage);
    }

    public void waitForMessageToDisappearUsingProgrammaticFluentWait(String expectedAlertMessage) {
        withTimeoutOf(Duration.ofSeconds(10))
                .waitForTextToDisappear(expectedAlertMessage, 10000);
    }
}
