package com.seleniumeasy.demo.acceptancetests;

import com.seleniumeasy.demo.pageobjects.AlertPage;
import com.seleniumeasy.demo.pageobjects.ModalDialogPage;
import net.serenitybdd.annotations.Managed;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class WhenWaitingForElements {
    @Managed(driver = "chrome")
    WebDriver driver;
    private ModalDialogPage modalDialogPage;
    private AlertPage alertPage;

    /*
    * Relies Implicit Wait set to 2000ms in Serenity
    * */
    @Test
    public void waitingForAModalDialog(){
        modalDialogPage.openModalDialogPage();

        modalDialogPage.saveChangesButton().shouldNotBeVisible();

        modalDialogPage.launchModal();

        //*Implicit wait doing its thing here, hidden away from code*/

        //Assertion works because page has had enough time to load the button
        modalDialogPage.saveChangesButton().shouldBeVisible();

        modalDialogPage.saveChanges();

        //*The modal closes following which implicit wait doing its thing here, hidden away from code*/

        //Assertion works because page has had enough time to unload the button
        modalDialogPage.saveChangesButton().shouldNotBeVisible();
    }

    /*
     * Relies on Fluent Wait configuration
     * */
    @Test
    public void waitingForAnAlertToDisappear(){
        String expectedAlertMessage = "I'm an autocloseable success message.";

        alertPage.openAlertPage();

        alertPage.openAutoCloseableSuccessAlertBox();

        Assertions.assertThat(alertPage.message())
                                                        .contains(expectedAlertMessage);

        //wait for five seconds
        alertPage.waitForMessageToDisappear(expectedAlertMessage);

    /*        You can no longer assert on the text because the text is gone after the box auto-closes'
        So we employ the element invisibility as a state indicator technique  to validate*/
        alertPage.autoCloseableAlertBox.shouldNotBeVisible();
    }

    /*
      Same test/ logic as above but Fluent wait time is code on the fly in the code
     * */
    @Test
    public void waitingForAnAlertToDisappearUsingProgrammaticFluentWait(){
        String expectedAlertMessage = "I'm an autocloseable success message.";

        alertPage.openAlertPage();

        alertPage.openAutoCloseableSuccessAlertBox();

        Assertions.assertThat(alertPage.message())
                .contains(expectedAlertMessage);

        //wait for five seconds using configured Fluent Wait time of 6 seconds
        //alertPage.waitForMessageToDisappear(expectedAlertMessage);

        //wait for 10 seconds using on-the-fly Fluent Wait time technique
        alertPage.waitForMessageToDisappearUsingProgrammaticFluentWait(expectedAlertMessage);

    /*        You can no longer assert on the text because the text is gone after the box auto-closes'
        So we employ the element invisibility as a state indicator technique  to validate*/
        alertPage.autoCloseableAlertBox.shouldNotBeVisible();
    }
}
