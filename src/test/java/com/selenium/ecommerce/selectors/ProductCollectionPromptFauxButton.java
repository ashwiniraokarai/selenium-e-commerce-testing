package com.selenium.ecommerce.selectors;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.UIInteractions;
import org.openqa.selenium.By;

public class ProductCollectionPromptFauxButton extends UIInteractions {
    //A more generalized version of exact text based match that can take the text-to-match as a parameter
    public WebElementFacade withExactText(String collectionPromptText){
        //return find(By.xpath("//span[text()='Shop New Yoga']"));
        return find(By.xpath("//span[text()='"+collectionPromptText+"']"));
    }
}
