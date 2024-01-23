package com.selenium.ecommerce.actions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractions;
import org.openqa.selenium.By;

public class ProductCollectionActions extends UIInteractions {
    @Step("Read Heading on Collections Listing Page")
    public String collectionsHeadingOnPage(){
        return find(By.xpath("//h1[@id='page-title-heading']")).getText();
    }
}
