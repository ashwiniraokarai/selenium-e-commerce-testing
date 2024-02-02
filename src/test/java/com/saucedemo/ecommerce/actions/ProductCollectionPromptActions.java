package com.saucedemo.ecommerce.actions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractions;
import org.openqa.selenium.By;

public class ProductCollectionPromptActions extends UIInteractions {
    @Step
    public void clickOnProductCollection(String productCollectionText){
        find(By.partialLinkText(productCollectionText)).click();
    }
}
