package com.selenium.ecommerce.pageobjects;

import net.serenitybdd.core.pages.PageComponent;
import net.serenitybdd.core.pages.WebElementFacade;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/*
*Extends PageComponents as opposed to PageObjects
* This is because ShoppingCart is part of a Page, not an entire Page by itself
 */
public class ShoppingCartComponent extends PageComponent {
    @FindBy(css = ".showcart")
    WebElementFacade showCartLink;

    @FindBy(css = "#mini-cart li.product-item .product-item-name")
    WebElementFacade miniCartContents;

    @FindBy(css = ".loader")
    WebElementFacade spinnerAnimation;

    public void showCartSummary() {
        showCartLink.click();
    }

    public void waitForCartIconToUpdateCount(){
        spinnerAnimation.waitUntilVisible();
        spinnerAnimation.waitUntilNotVisible();
    }

    public String productTitleInMiniCart() {
        return miniCartContents.getText();
    }
}
