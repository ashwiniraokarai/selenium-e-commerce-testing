package com.seleniumeasy.demo.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class CheckboxForm extends PageObject {
    @FindBy(css = "input[id='isAgeSelected'][type='checkbox']")
    WebElementFacade checkbox;

    @FindBy(css = "#txtAge")
    WebElementFacade successMessage;

    public void openCheckBoxFormPage() {
        openUrl("https://demo.seleniumeasy.com/basic-checkbox-demo.html");
    }

    public void selectCheckBox() {
        checkbox.click();
    }

    public String successMessage() {
        return successMessage.getText() ;
    }

    @FindBy(css = "input#check1")
    WebElementFacade checkAllFauxButton;

    private WebElementFacade checkBoxElementWithAccompanyingText(String accompanyingText) {
        return find(By.xpath("//label[contains(., '" +accompanyingText+"')]/input"));
    }
    public boolean checkBoxStateOf(String checkBoxAccompanyingText){
        return checkBoxElementWithAccompanyingText(checkBoxAccompanyingText).isSelected();
    }

    public void submitFormToCheckAllBoxes() {
        checkAllFauxButton.click();
    }
}