package com.seleniumeasy.demo.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.w3c.dom.html.HTMLInputElement;

import java.awt.*;

public class RadioButtonGroupsForm extends PageObject {
    @FindBy(xpath = "//button[text()='Get values']")
    private WebElementFacade getValueButton;

    @FindBy(css = ".groupradiobutton")
    private WebElementFacade displayedMessage;

    public WebElementFacade radioButtonGroupWithValue(String radioButtonGroup, String value) {
       return find(By.cssSelector("input[name='"+radioButtonGroup+"'][value='"+value+"']"));
    }

    public void openRadioButtonFormPage() {
        openUrl("https://demo.seleniumeasy.com/basic-radiobutton-demo.html");
    }

    public void selectGenderRadioButtonWithValue(String choiceOfGender) {
        radioButtonGroupWithValue("gender", choiceOfGender).click();
    }

    public void selectAgeGroupRadioButtonWithValue(String choiceOfAgeGroup) {
        radioButtonGroupWithValue("ageGroup", choiceOfAgeGroup).click();
    }

    public void submit() {
        getValueButton.click();
    }

    public String textOfDisplayedMessageForGender() {
        return displayedMessage.getText();
    }
}
