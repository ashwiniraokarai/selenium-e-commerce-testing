package com.seleniumeasy.demo.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

import static java.lang.Integer.parseInt;

public class TwoInputFieldsForm extends PageObject {
    @FindBy(css = "#value1")
    WebElementFacade inputBoxForValueOne;

    @FindBy(css = "#value2")
    WebElementFacade inputBoxForValueTwo;

    //note: xpath is good for those buttons that are best located by their inner text
    @FindBy(xpath = "//button[text()='Get Total']")
    WebElementFacade getTotalButton;

    @FindBy(css = "#displayvalue")
    WebElementFacade displayedTotal;

    public void openSimpleFormPage() {
        openUrl("https://demo.seleniumeasy.com/basic-first-form-demo.html");
    }

    public void enterNumberForValueOne(String numberOne) {
        inputBoxForValueOne.type(numberOne);
    }

    public void enterNumberForValueTwo(String numberTwo) {
        inputBoxForValueTwo.type(numberTwo);
    }

    public void submitValues() {
        getTotalButton.click();
    }

    public Integer displayedTotal() {
       return parseInt(displayedTotal.getText());
    }
}
