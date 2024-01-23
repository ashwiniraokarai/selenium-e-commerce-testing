package com.selenium.ecommerce.selectors;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.UIInteractions;
import org.openqa.selenium.By;

public class ShowNewYogaCollectionPromptFauxButton extends UIInteractions {
    /*
     *Multiple techniques to locate the Shop New Yoga element shown in separate methods
     * Ideally, these methods would live outside the Test file and maybe in their own package "selectors" or "elements"
     */
    public WebElementFacade shopNewYogaFauxButtonUsingClassNamesEquality(){
        return find(By.xpath("//span[@class='action more button']"));
    }

    public WebElementFacade shopNewYogaFauxButtonUsingClassNamesContains(){
        return find(By.xpath("//span[contains(@class, 'more button')]"));
    }

    public WebElementFacade shopNewYogaFauxButtonUsingTextEquality(){
        return find(By.xpath("//span[text()='Shop New Yoga']"));
    }
}
