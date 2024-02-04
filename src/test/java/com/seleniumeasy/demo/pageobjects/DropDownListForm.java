package com.seleniumeasy.demo.pageobjects;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DropDownListForm extends PageObject {
    @FindBy(css = "#select-demo")
    private WebElementFacade  selectADaySingleSelectDropdownList;

    @FindBy(css = "#multi-select")
    private WebElementFacade  selectStatesMultiSelectDropdownList;

    public void openDropDownListFormPage(){
       openUrl("https://demo.seleniumeasy.com/basic-select-dropdown-demo.html");
   }

    //For single-select drop down list
    public void selectADayFromSingleSelectDropDown(String dayToSelect) {
        selectADaySingleSelectDropdownList.selectByValue(dayToSelect);
    }

    //For single-select drop down list
    public String currentSelectionOnDropDownList() {
        return selectADaySingleSelectDropdownList.getSelectedValue();
    }

    //For multi-select drop down list
    //Note: argument is flex to receive as many Strings as sent over or even a String Array
    public void selectStatesFromMultiSelectDropDown(String...strings) {
        for(String state : strings){
            selectStatesMultiSelectDropdownList.selectByValue(state);
        }
    }

    //For multi-select drop down list
    //Note: returns a List
    public List<String> currentSelectionsOnDropDownList() {
        return selectStatesMultiSelectDropdownList.getSelectedValues();
    }
}
