package com.seleniumeasy.demo.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class RadioButtonForm extends PageObject {
    private WebElementFacade simpleRadioButtonWithValue(String value) {
        return find(By.cssSelector("input[name='optradio'][value='"+value+"']"));
    }

    @FindBy(css = "#buttoncheck")
    private WebElementFacade getCheckedValueButton;

    @FindBy(css = " .radiobutton")
    private WebElementFacade displayedMessage;

    public void openRadioButtonFormPage() {
        openUrl("https://demo.seleniumeasy.com/basic-radiobutton-demo.html");
    }

    public void selectSimpleRadioButtonWithValue(String gender) {
        simpleRadioButtonWithValue(gender).click();
    }

    public void submit() {
        getCheckedValueButton.click();
    }

    public String textOfDisplayedMessage() {
        return displayedMessage.getText();
    }
}
