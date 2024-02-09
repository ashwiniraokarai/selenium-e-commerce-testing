package com.seleniumeasy.demo.acceptancetests;

import com.seleniumeasy.demo.pageobjects.AlertPage;
import com.seleniumeasy.demo.pageobjects.GetNewUserLoadingIconPage;
import com.seleniumeasy.demo.pageobjects.ModalDialogPage;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.core.steps.UIInteractions;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenWaitingForElements extends UIInteractions {
    @Managed(driver = "chrome")
    WebDriver driver;
    private ModalDialogPage modalDialogPage;
    private AlertPage alertPage;
    private GetNewUserLoadingIconPage getNewUserLoadingIconPage;

    /*
    * Relies on "Implicit Wait" set to the default timeout (2000ms) in Serenity
    * */
    @Test
    public void waitForAModalDialog(){
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
     * Relies on Fluent Wait configuration set to 6000ms in the conf file
     * aka "Preconfigured Fluent Wait"
     * */
    @Test
    public void waitForAnAlertToDisappear(){
        String expectedAlertMessage = "I'm an autocloseable success message.";

        alertPage.openAlertPage();

        alertPage.openAutoCloseableSuccessAlertBox();

        Assertions.assertThat(alertPage.message())
                                                        .contains(expectedAlertMessage);

        //wait for five seconds
        alertPage.waitForMessageToDisappear(expectedAlertMessage);

        /* You can no longer assert on the text because the text is gone after the box auto-closes'
        * So we employ the element invisibility as a state indicator technique  to validate*/
        alertPage.autoCloseableAlertBox.shouldNotBeVisible();
    }

    /*
     *Same test/ logic as above but Fluent wait time is set on the fly in the code
     * aka "Programmatic Fluent Wait"
     */
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

        /* You can no longer assert on the text because the text is gone after the box auto-closes'
            So we employ the element invisibility as a state indicator technique  to validate*/
        alertPage.autoCloseableAlertBox.shouldNotBeVisible();
    }

    /*
    * Relies on "Explicit Wait" using Expected Conditions
    * */
    @Test
    public void waitForSpinnerToDisappear(){
        getNewUserLoadingIconPage.openNewUserLoadingIconPage();

        getNewUserLoadingIconPage.openNewUserDetails();

        //Check that loading "state" has begun to show on the page
        Assertions.assertThat(getNewUserLoadingIconPage.userDetailsPane()).contains("loading...");

        //wait for user details to load
        getNewUserLoadingIconPage.waitForLoadingStateToDisappear();

        Assertions.assertThat(getNewUserLoadingIconPage.userDetailsPane())
                .contains("First Name : ")
                .contains("Last Name : ");
    }
}
