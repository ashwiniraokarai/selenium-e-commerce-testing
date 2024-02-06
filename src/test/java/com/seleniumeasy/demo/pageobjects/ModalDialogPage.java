package com.seleniumeasy.demo.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class ModalDialogPage extends PageObject {

    // there are two links that have the very same link text, but this method is designed to only access the first one (as opposed to css selector)
    private WebElementFacade launchModalButton(){
        return  find(By.linkText("Launch modal"));
    }

    // there are two links that have the very same link text, but this method is designed to only access the first one (as opposed to css selector)
    public WebElementFacade saveChangesButton(){
        return find(By.linkText("Save changes"));
    }

    public void openModalDialogPage(){
        openUrl("https://demo.seleniumeasy.com/bootstrap-modal-demo.html");
    }

    public void launchModal() {
        launchModalButton().click();
    }

    public void saveChanges(){
        saveChangesButton().click();
    }
}
