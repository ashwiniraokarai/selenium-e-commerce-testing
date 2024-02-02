package com.saucedemo.ecommerce.actions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.steps.UIInteractions;
import org.openqa.selenium.By;

public class PageHeadActions extends UIInteractions {
    @Step("Read page title")
    public String pageTitle(){
        return getTitle();
    }
}
