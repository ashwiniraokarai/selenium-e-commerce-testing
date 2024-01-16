package com.selenium.ecommerce.actions;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractions;

public class NavigationActions extends UIInteractions {
    @Step("Open the Luma Page")
    public void openTheLumaLandingPage(){
        openUrl("https://magento.softwaretestingboard.com/");
    }
}
