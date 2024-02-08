package com.seleniumeasy.demo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class InputFieldsFormWithoutSerenity extends PageFactory {
    WebDriver driver;

    @FindBy(css = "input#user-message")
    WebElement textInputField;

    @FindBy(css = "#display")
    WebElement displayedMessageArea;

    @FindBy(xpath = "//button[text()='Show Message']")
    WebElement showMessageButton;
    public InputFieldsFormWithoutSerenity(WebDriver driver){
        this.driver = driver;

        //Necessary step: initialize all web elements located by @FindBy annotation
        PageFactory.initElements(driver, this);
    }

    public void enterMessage(String message) {
        textInputField.sendKeys(message);
    }

    public void submit() {
        showMessageButton.click();
    }

    public String getDisplayedMessage() {
        return  displayedMessageArea.getText();
    }
}
