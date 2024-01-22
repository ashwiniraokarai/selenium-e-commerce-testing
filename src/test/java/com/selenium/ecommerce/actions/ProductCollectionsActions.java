package com.selenium.ecommerce.actions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractions;
import org.openqa.selenium.By;

public class ProductCollectionsActions extends UIInteractions {
    @Step
    public void clickOnProductCollection(String productCollectionText){
        find(By.partialLinkText(productCollectionText)).click();
    }
}
