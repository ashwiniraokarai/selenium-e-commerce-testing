package com.seleniumeasy.demo.acceptancetests;

import com.seleniumeasy.demo.pageobjects.SingleInputFieldForm;
import com.seleniumeasy.demo.pageobjects.TwoInputFieldsForm;
import net.serenitybdd.annotations.Managed;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static java.lang.Integer.parseInt;

public class TextInputsAndSubmit {
    SingleInputFieldForm simpleFormPage;
    @Managed(driver = "chrome")
    WebDriver driver;
    private TwoInputFieldsForm twoInputFieldsForm;

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
}
