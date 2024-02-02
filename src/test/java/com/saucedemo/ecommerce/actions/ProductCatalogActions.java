package com.saucedemo.ecommerce.actions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractions;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;

//although the catalog is shown on home page but could be there in other places in the store too?
public class ProductCatalogActions extends UIInteractions {
    @Step("Click on product {0} to reveal details")
    public void clickOnProduct(String productName){
/*    click on the "Radiant Tee" product in the "Hot Sellers" section at the bottom of the Home page
        This element can be clicked thro the link in the image or the link right below the image
        But using a trick, I'll locate the link simply thro its text
        Css selectors don't perform matches to text, so we'll use one of those static shortcut methods that By provides*/
        find(By.linkText(productName)).click();
    }
}
