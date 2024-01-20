package com.selenium.ecommerce.actions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractions;
import net.serenitybdd.screenplay.ui.Button;
import org.openqa.selenium.By;

public class SubscribeActions extends UIInteractions {
    @Step()
    public void fillOutAndSubmitSubscriptionForm(){
        find(By.id("mce-EMAIL")).type("dino@y.com");
        //find(By.cssSelector("#mce-EMAIL")).sendKeys("x@y.com");
        find(Button.withText("Subscribe")).click();
    }

    @Step()
    public String afterSubscriptionText(){
        return find(By.id("mce-success-response")).getText();
    }
}
