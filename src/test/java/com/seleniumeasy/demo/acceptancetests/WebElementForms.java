package com.seleniumeasy.demo.acceptancetests;

import com.seleniumeasy.demo.pageobjects.CheckboxForm;
import com.seleniumeasy.demo.pageobjects.SingleInputFieldForm;
import com.seleniumeasy.demo.pageobjects.TwoInputFieldsForm;
import net.serenitybdd.annotations.Managed;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static java.lang.Integer.parseInt;

public class WebElementForms {
    SingleInputFieldForm simpleFormPage;
    @Managed(driver = "chrome")
    WebDriver driver;
    private TwoInputFieldsForm twoInputFieldsForm;
    private CheckboxForm checkboxForm;

    /*
    * Single Input Field:
    * Submit a text and see it displayed back
    * */
    @Test
    public void canInputAndSeeMessage(){
        simpleFormPage.openSimpleFormPage();
        simpleFormPage.enterMessage("Page Object Model in the works");
        simpleFormPage.submitMessage();

        Assertions.assertThat(simpleFormPage.displayedMessage()).isEqualTo("Page Object Model in the works");
    }

    /*
     * Two Input Fields:
     * Submit 2 numbers and see the sum displayed back
     * */
    @Test
    public void canInputTwoFieldsAndSeeTotal(){
        String numberOne = "3";
        String numberTwo = "4";
        Integer expectedTotal = parseInt(numberOne, 10) + parseInt(numberTwo, 10);

        twoInputFieldsForm.openSimpleFormPage();
        twoInputFieldsForm.enterNumberForValueOne(numberOne);
        twoInputFieldsForm.enterNumberForValueTwo(numberTwo);
        twoInputFieldsForm.submitValues();

        Assertions.assertThat(twoInputFieldsForm.displayedTotal()).isEqualTo(expectedTotal);
    }

    /*
    * Single checkbox:
    * Select the Checkbox and see a success message
    * */
    @Test
    public void canSelectCheckBox(){
        String expectedMessage = "Success - Check box is checked";

        checkboxForm.openCheckBoxFormPage();
        checkboxForm.selectCheckBox();

        Assertions.assertThat(checkboxForm.successMessage()).isEqualTo(expectedMessage);
    }

    /*
     * Multiple checkboxes and a single "Check All" button that selects all checkboxes for you
     * Check that the Checkboxes are not already selected (via the state of each CheckBox)
     * Select the "Check All" button
     * Check that the Checkboxes are now selected (via the state of each CheckBox, again)
     * */
    @Test
    public void canDetermineCheckBoxStateAndSelectMultipleCheckBoxes(){
        checkboxForm.openCheckBoxFormPage();
        Assertions.assertThat(checkboxForm.checkBoxStateOf("Option 1")).isFalse();
        Assertions.assertThat(checkboxForm.checkBoxStateOf("Option 2")).isFalse();
        Assertions.assertThat(checkboxForm.checkBoxStateOf("Option 3")).isFalse();
        Assertions.assertThat(checkboxForm.checkBoxStateOf("Option 4")).isFalse();

        checkboxForm.submitFormToCheckAllBoxes();

        Assertions.assertThat(checkboxForm.checkBoxStateOf("Option 1")).isTrue();
        Assertions.assertThat(checkboxForm.checkBoxStateOf("Option 2")).isTrue();
        Assertions.assertThat(checkboxForm.checkBoxStateOf("Option 3")).isTrue();
        Assertions.assertThat(checkboxForm.checkBoxStateOf("Option 4")).isTrue();
    }
}
