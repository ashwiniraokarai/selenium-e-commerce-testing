package com.seleniumeasy.demo.acceptancetests;

import com.seleniumeasy.demo.pageobjects.ModalDialogPage;
import net.serenitybdd.annotations.Managed;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class WhenWaitingForElements {
    @Managed(driver = "chrome")
    WebDriver driver;
    private ModalDialogPage modalDialogPage;

    @Test
    public void waitingForAModalDialog(){
        modalDialogPage.openModalDialogPage();

        modalDialogPage.saveChangesButton().shouldNotBeVisible();

        modalDialogPage.launchModal();

        modalDialogPage.saveChangesButton().shouldBeVisible();

        modalDialogPage.saveChanges();

        modalDialogPage.saveChangesButton().shouldNotBeVisible();
    }
}
