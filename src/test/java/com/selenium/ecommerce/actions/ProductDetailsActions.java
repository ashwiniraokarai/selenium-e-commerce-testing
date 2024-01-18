package com.selenium.ecommerce.actions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractions;
import org.openqa.selenium.By;

public class ProductDetailsActions extends UIInteractions {
    //Notice the use of parameterized product name in the Step description, to pull dynamic value in the test report
    @Step()
    public String productHeadingOnPage() {
        return find(By.cssSelector(".page-title")).getText();
    }
}
