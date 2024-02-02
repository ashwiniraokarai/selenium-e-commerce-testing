package com.seleniumeasy.demo.acceptancetests;

import com.seleniumeasy.demo.pageobjects.*;
import net.serenitybdd.annotations.Managed;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;

import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Integer.parseInt;

public class WebElementForms {
    SingleInputFieldForm simpleFormPage;
    @Managed(driver = "chrome")
    WebDriver driver;
    private TwoInputFieldsForm twoInputFieldsForm;
    private CheckboxForm checkboxForm;
    private RadioButtonForm radioButtonForm;
    private RadioButtonGroupsForm radioButtonGroupsForm;

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

        /*    //Assertion refactored to write DRY code using Assertj's allMatch() method
        Assertions.assertThat(checkboxForm.checkBoxStateOf("Option 1")).isFalse();
        Assertions.assertThat(checkboxForm.checkBoxStateOf("Option 2")).isFalse();
        Assertions.assertThat(checkboxForm.checkBoxStateOf("Option 3")).isFalse();
        Assertions.assertThat(checkboxForm.checkBoxStateOf("Option 4")).isFalse();*/

        List<String> ALL_THE_CHECKBOX_LOCATING_TEXT = new ArrayList<String>();
        Collections.addAll(ALL_THE_CHECKBOX_LOCATING_TEXT, "Option 1", "Option 2", "Option 3", "Option 4");

        Assertions.assertThat(ALL_THE_CHECKBOX_LOCATING_TEXT).allMatch(
                option -> !checkboxForm.checkBoxStateOf(option)
        );

        checkboxForm.submitFormToCheckAllBoxes();

        Assertions.assertThat(ALL_THE_CHECKBOX_LOCATING_TEXT).allMatch(
                option -> checkboxForm.checkBoxStateOf(option)
        );

     /*   Assertions.assertThat(checkboxForm.checkBoxStateOf("Option 1")).isTrue();
        Assertions.assertThat(checkboxForm.checkBoxStateOf("Option 2")).isTrue();
        Assertions.assertThat(checkboxForm.checkBoxStateOf("Option 3")).isTrue();
        Assertions.assertThat(checkboxForm.checkBoxStateOf("Option 4")).isTrue();*/
    }

    /*
     * Radio Button and a Submit button that produces a feedback of your Selection
     * Select a Radio Button in the Radio Button Group
     * Submit
     * Validate the feedback message
     * */
    @ParameterizedTest(name="Select {0}")
    @CsvSource({
            "Male",
            "Female"
    })
    public void canSelectARadioButton(String selection){
        radioButtonForm.openRadioButtonFormPage();
        radioButtonForm.selectSimpleRadioButtonWithValue(selection);
        radioButtonForm.submit();

        Assertions.assertThat(radioButtonForm.textOfDisplayedMessage()).isEqualTo("Radio button '"+selection+"' is checked");
    }

    /*
     * Radio Button from one Radio Group (gender), then another one on a different Radio Group (age group)
     * Submit and Validate the Feedback Message using Chained Assertion
     * The highlight in the test is the chained Assertion technique
     * The highlight in the Page Class is the single selector method parameterized to cater to both radio button groups
     * */
    @ParameterizedTest(name = "Select {0}: {1}")
    @CsvSource({
            "Male, 0 - 5",
            "Female, 15 - 50",
            "Female, 5 - 15"
    })
    public void canSelectRadioButtonsOnSeparateGroups(String choiceOfGender, String  choiceOfAgeGroup){
        radioButtonGroupsForm.openRadioButtonFormPage();
        radioButtonGroupsForm.selectGenderRadioButtonWithValue(choiceOfGender);
        radioButtonGroupsForm.selectAgeGroupRadioButtonWithValue(choiceOfAgeGroup);
        radioButtonGroupsForm.submit();

        Assertions.assertThat(radioButtonGroupsForm.textOfDisplayedMessageForGender())
                .contains(choiceOfGender)
                .contains(choiceOfAgeGroup);
    }
}
