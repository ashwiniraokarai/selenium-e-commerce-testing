package com.seleniumeasy.demo.acceptancetests;

import com.seleniumeasy.demo.pageobjects.TwoInputFieldsForm;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.core.steps.UIInteractions;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import java.util.stream.Stream;

@ExtendWith(SerenityJUnit5Extension.class)
public class ParameteredTestWithSerenity extends UIInteractions {

    @Managed
    WebDriver driver;
    private TwoInputFieldsForm twoInputFieldsForm;

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvFileSource(resources = "/calculations.csv", numLinesToSkip = 1)
    public void canOperateOnInputsFromCSVFileSource(String numberOne, String numberTwo, Integer expectedTotal){
        twoInputFieldsForm.openSimpleFormPage();
        twoInputFieldsForm.enterNumberForValueOne(numberOne);
        twoInputFieldsForm.enterNumberForValueTwo(numberTwo);
        twoInputFieldsForm.submitValues();

        Assertions.assertThat(twoInputFieldsForm.displayedTotal()).isEqualTo(expectedTotal);
    }

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource(
            {
                    "1, 2, 3",
                    "10,20, 30",
                    "10,-5,5",
                    "0, 100, 100",
                    "1000, 2000, 3000"
            }
    )
    public void canOperateOnInputsFromCSVSource(String numberOne, String numberTwo, Integer expectedTotal){
        twoInputFieldsForm.openSimpleFormPage();
        twoInputFieldsForm.enterNumberForValueOne(numberOne);
        twoInputFieldsForm.enterNumberForValueTwo(numberTwo);
        twoInputFieldsForm.submitValues();

        Assertions.assertThat(twoInputFieldsForm.displayedTotal()).isEqualTo(expectedTotal);
    }

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @MethodSource("testData")
    public void canOperateOnInputsFromMethodSource(String numberOne, String numberTwo, Integer expectedTotal){
        twoInputFieldsForm.openSimpleFormPage();
        twoInputFieldsForm.enterNumberForValueOne(numberOne);
        twoInputFieldsForm.enterNumberForValueTwo(numberTwo);
        twoInputFieldsForm.submitValues();

        Assertions.assertThat(twoInputFieldsForm.displayedTotal()).isEqualTo(expectedTotal);
    }

    //A Method that is the Data Provider or Data Source
    public static Stream<Arguments> testData(){
        return Stream.of(
                Arguments.of("1", "2", 3),
                Arguments.of("10", "20", 30),
                Arguments.of("10", "-5", 5),
                Arguments.of("0", "100", 100),
                Arguments.of("1000", "2000", 3000)
        );
    }
}
