package com.seleniumeasy.demo.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class SingleInputFieldForm extends PageObject {
    @FindBy(css = "input#user-message")
    WebElementFacade inputBoxForMessage;

    @FindBy(xpath = "//button[text()='Show Message']")
    WebElementFacade showMessageButton;

    @FindBy(css = "#display")
    WebElementFacade messageDisplayArea;

    public void openSimpleFormPage(){
        openUrl("https://demo.seleniumeasy.com/basic-first-form-demo.html");
    }

    public void enterMessage(String message){
        inputBoxForMessage.type(message);
    }

    public void submitMessage(){
        showMessageButton.click();
    }

    public String displayedMessage(){
        return messageDisplayArea.getText();
    }
}
