package com.selenium.ecommerce.actions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.steps.UIInteractions;
import org.openqa.selenium.By;

public class FooterActions extends UIInteractions {
    @Step()
    public void clickOnMailingListSubscription(){
        find(By.linkText("Subscribe to our mailing list")).click();
    }
}
